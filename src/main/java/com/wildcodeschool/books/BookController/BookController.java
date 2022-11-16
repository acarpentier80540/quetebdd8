package com.wildcodeschool.books.BookController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wildcodeschool.books.BookEntity.Book;
import com.wildcodeschool.books.BookRespository.BookRespository;



import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRespository bookRespository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookRespository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id){
        return (Book) bookRespository.findById(id).get(id);
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRespository.findByTitleOrAuthorOrDescriptionContaining(searchTerm, searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRespository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        // getting book
        Book bookToUpdate = (Book) bookRespository.findById(id).get(id);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return bookRespository.save(bookToUpdate);
    }

    @DeleteMapping("books/{id}")
    @ResponseBody
    public String delete(@PathVariable int id){
        bookRespository.deleteById(id);
        return "is deleted";
    }

}