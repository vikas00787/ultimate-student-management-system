document.addEventListener("DOMContentLoaded", () => {

    console.log("Student Module Loaded 🚀");

    // ==============================
    // DELETE CONFIRMATION
    // ==============================

    const deleteButtons = document.querySelectorAll(".btn-outline-danger, .btn-danger");

    deleteButtons.forEach(btn => {

        btn.addEventListener("click", (e) => {

            const confirmDelete = confirm("⚠️ Are you sure?\n\nThis student record will be permanently deleted.");

            if (!confirmDelete) {

                e.preventDefault();

            } else {

                const row = btn.closest("tr");

                if (row) {

                    row.style.transition = "all 0.4s ease";
                    row.style.backgroundColor = "#ffdddd";

                    setTimeout(() => {
                        row.style.opacity = "0";
                        row.style.transform = "translateX(-20px)";
                    }, 100);

                }

                console.log("Student record deleted");
            }

        });

    });


    // ==============================
    // TABLE HOVER EFFECT
    // ==============================

    const rows = document.querySelectorAll("tbody tr");

    rows.forEach(row => {

        row.addEventListener("mouseenter", () => {
            row.style.backgroundColor = "#f8f9fc";
        });

        row.addEventListener("mouseleave", () => {
            row.style.backgroundColor = "";
        });

    });


    // ==============================
    // PAGE LOAD ANIMATION
    // ==============================

    const table = document.querySelector(".custom-table");

    if (table) {

        table.style.opacity = "0";
        table.style.transform = "translateY(20px)";
        table.style.transition = "all 0.6s ease";

        setTimeout(() => {
            table.style.opacity = "1";
            table.style.transform = "translateY(0)";
        }, 200);

    }

});