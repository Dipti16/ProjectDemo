package com.example.ProjectDemoExample.Entity;

import jakarta.persistence.*;

@Entity
public class Book
{
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_seq")
            @SequenceGenerator(name = "book_seq")
    long id;
    String author;
    String name;
    float price;

    public Book()
    {
    }

    public Book(String author, String name, float price) {
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
