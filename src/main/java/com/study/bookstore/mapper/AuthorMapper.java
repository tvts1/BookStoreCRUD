package com.study.bookstore.mapper;

import com.study.bookstore.dto.AuthorDTO;
import com.study.bookstore.dto.BookDTO;
import com.study.bookstore.entities.Author;
import com.study.bookstore.entities.Book;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static Author toEntity(AuthorDTO dto) {
        Author author = new Author();
        author.setName(dto.name());

        List<Book> books = dto.books().stream()
                .map(bookDTO -> BookMapper.toEntity(bookDTO, author))
                .collect(Collectors.toList());

        author.setBooks(books);

        return author;
    }

    public static AuthorDTO toDTO(Author author) {
        List<BookDTO> bookDTOs = author.getBooks().stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());

        return new AuthorDTO(
                author.getName(),
                bookDTOs
        );
    }
}
