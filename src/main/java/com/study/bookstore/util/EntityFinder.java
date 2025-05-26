package com.study.bookstore.util;

import com.study.bookstore.exception.NotFoundException;
import com.study.bookstore.entities.Author;
import com.study.bookstore.entities.Book;
import com.study.bookstore.repository.AuthorRepository;
import com.study.bookstore.repository.BookRepository;

public class EntityFinder {

    public static Book findBookOrThrow(BookRepository bookRepository, Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
    }

    public static Author findAuthorOrThrow(AuthorRepository authorRepository, Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found with id: " + id));
    }
}
