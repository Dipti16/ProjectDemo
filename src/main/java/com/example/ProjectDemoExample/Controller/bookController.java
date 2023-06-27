package com.example.ProjectDemoExample.Controller;

import com.example.ProjectDemoExample.Dao.BookRepo;
import com.example.ProjectDemoExample.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/book_register/")
    public String show() {
        return "bookReg";
    }

    @GetMapping("/available_book/")
    public String getAllBooks(Model model, Book book)
    {
        List <Book> list=bookRepo.findAll();
        model.addAttribute("booklist",list);
        return "bookList";
    }

    @PostMapping("/save")
    public String save(Model model, Book book)
    {
        bookRepo.save(book);
        return "redirect:/available_book/";

    }



}
