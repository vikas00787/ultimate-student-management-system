package com.example.library.repositry; // Spelling check: repositry vs repository

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> { 
    // Yahan Book aur Long (ID ka type) hona chahiye
}