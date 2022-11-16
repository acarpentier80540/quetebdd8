package com.wildcodeschool.books.BookRespository;



import com.wildcodeschool.books.BookEntity.Book;


import org.springframework.stereotype.Repository;
import repository.BookRepository;
import repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleOrAuthorOrDescriptionContaining(String text, String textAgain, String needAnotherOne);

    Book save(Book book);

    List<Book> findAll();

    Map findById(int id);

    BookRepository deleteById(int id);
}