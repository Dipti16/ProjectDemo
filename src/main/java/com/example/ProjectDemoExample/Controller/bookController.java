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
public class bookController
{
    @Autowired
    BookRepo bookRepo;
    @GetMapping("/")
    public String home()
    {
        return "index";
    }
    @GetMapping("/home/")
    public String show(Model model)
    {
        List<Book> list=bookRepo.findAll();
        model.addAttribute("bookList",list);
        return "bookReg";
    }
    @PostMapping("/book/")
    public String shodata(Model model, Book book) {
        bookRepo.save(book);
        List<Book> bookList = bookRepo.findAll();
        model.addAttribute("bookList", bookList);
        return "bookReg";
    }
}
