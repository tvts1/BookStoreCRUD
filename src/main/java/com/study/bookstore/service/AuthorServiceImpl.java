package com.study.bookstore.service;

import com.study.bookstore.dto.AuthorDTO;
import com.study.bookstore.dto.BookDTO;
import com.study.bookstore.entities.Author;
import com.study.bookstore.entities.Book;
import com.study.bookstore.mapper.AuthorMapper;
import com.study.bookstore.mapper.BookMapper;
import com.study.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import static com.study.bookstore.util.EntityFinder.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDTO getById(Long id) {
        Author author = findAuthorOrThrow(authorRepository, id);
        return AuthorMapper.toDTO(author);
    }

    @Override
    public List<AuthorDTO> getAll() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorMapper::toDTO)
                .toList();
    }

    @Override
    public AuthorDTO create(AuthorDTO dto) {
        Author author = AuthorMapper.toEntity(dto);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toDTO(savedAuthor);
    }

    @Override
    public AuthorDTO update(Long id, AuthorDTO dto) {
        Author existingAuthor = findAuthorOrThrow(authorRepository, id);

        existingAuthor.setName(dto.name());

        List<Book> books = dto.books().stream()
                .map(BookDTO -> BookMapper.toEntity(BookDTO, existingAuthor))
                .collect(Collectors.toList());

        existingAuthor.setBooks(books);

        authorRepository.save(existingAuthor);
        return AuthorMapper.toDTO(existingAuthor);
    }

    @Override
    public void delete(Long id) {
        Author author = findAuthorOrThrow(authorRepository, id);
        authorRepository.delete(author);
    }
}
