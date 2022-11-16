package com.wildcodeschool.books.BookEntity;


import entity.Entity;

@Entity
public class Book {
    private Object GenerationType;

    private int id;

    private String title;
    private String author;
    private String description;

    public Book() {  }

    public Book(String title, String author, String description) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);
    }

    public Book(int id, String title, String author, String description) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}