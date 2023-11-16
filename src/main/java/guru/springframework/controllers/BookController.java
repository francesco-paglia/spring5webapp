package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
    
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // Si aggiunge al modello un attributo books che conterrà le informazioni sui libri
        // Questo attributo sarà utilizzabile nella View per stampare le informazioni ottenute
        model.addAttribute("books", bookRepository.findAll());
        
        return "books";
    }
}
