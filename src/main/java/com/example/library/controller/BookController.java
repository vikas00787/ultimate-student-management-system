package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repositry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	// 1. Home Page / Dashboard
	@GetMapping("/")
	public String home() {
		return "index";
	}

	// 2. View All Books (List Page)
	@GetMapping("/books")
	public String listBooks(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}

	// 3. Show Add Book Form
	@GetMapping("/addBook")
	public String showAddBookForm(Model model) {
		model.addAttribute("book", new Book()); // Empty object for form
		return "addBook";
	}

	// 4. Save or Update Book
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookRepository.save(book); // Agar ID hogi toh update karega, nahi toh naya save karega
		return "redirect:/books";
	}

	// 5. Delete Book
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/books";
	}

	// 6. Show Edit Book Form
	@GetMapping("/editBook/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

		model.addAttribute("book", book); // Purana data form mein dikhane ke liye
		return "addBook";
	}
}