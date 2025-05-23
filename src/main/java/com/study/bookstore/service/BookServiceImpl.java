package com.study.bookstore.service;

import com.study.bookstore.dto.BookDTO;
import com.study.bookstore.entities.Book;
import com.study.bookstore.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookDTO getById(Long id) {
        return null;
    }

    @Override
    public List<BookDTO> getAll() {
        return List.of();
    }

    @Override
    public BookDTO create(BookDTO dto) {

        var book = new Book(
                dto.title(),
                dto.authorId(),
                dto.year(),
                dto.isbn(),
                dto.price()
        );

        return repository.save(book);
    }

    @Override
    public BookDTO update(Long id, BookDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
