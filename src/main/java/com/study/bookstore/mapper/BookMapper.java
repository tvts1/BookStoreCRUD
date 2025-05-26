package com.study.bookstore.mapper;

import com.study.bookstore.dto.AuthorDTO;
import com.study.bookstore.dto.BookDTO;
import com.study.bookstore.entities.Author;
import com.study.bookstore.entities.Book;

public class BookMapper {

    public Book toEntity(BookDTO dto, Author author) {
        return new Book(
                null,
                dto.title(),
                author,
                dto.year(),
                dto.isbn(),
                dto.price()
        );
    }

    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor().getId(),
                book.getYear(),
                book.getIsbn(),
                book.getPrice()
        );
    }
}
