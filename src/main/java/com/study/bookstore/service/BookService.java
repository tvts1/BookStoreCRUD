package com.study.bookstore.service;

import com.study.bookstore.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO getById(Long id);
    List<BookDTO> getAll();
    BookDTO create(BookDTO dto);
    BookDTO update(Long id, BookDTO dto);
    void delete(Long id);
}
