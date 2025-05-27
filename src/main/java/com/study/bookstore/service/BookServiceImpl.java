package com.study.bookstore.service;

import com.study.bookstore.dto.BookDTO;
import com.study.bookstore.entities.Author;
import com.study.bookstore.entities.Book;
import com.study.bookstore.mapper.BookMapper;
import com.study.bookstore.repository.AuthorRepository;
import com.study.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import static com.study.bookstore.util.EntityFinder.*;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDTO getById(Long id) {
        Book book = findBookOrThrow(bookRepository, id);
        return BookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper::toDTO)
                .toList();
    }

    @Override
    public BookDTO create(BookDTO dto) {
        Author author = findAuthorOrThrow(authorRepository, dto.authorId());
        Book book = BookMapper.toEntity(dto, author);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    @Override
    public BookDTO update(Long id, BookDTO dto) {
        Book existingBook = findBookOrThrow(bookRepository, id);

        Author author = findAuthorOrThrow(authorRepository, dto.authorId());

        existingBook.setTitle(dto.title());
        existingBook.setPrice(dto.price());
        existingBook.setIsbn(dto.isbn());

        bookRepository.save(existingBook);
        return BookMapper.toDTO(existingBook);
    }

    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
