package com.study.bookstore.service;

import com.study.bookstore.dto.AuthorDTO;
import com.study.bookstore.entities.Author;
import com.study.bookstore.repository.AuthorRepository;
import static com.study.bookstore.util.EntityFinder.*;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDTO getById(Long id) {
    }

    @Override
    public List<AuthorDTO> getAll() {
        return List.of();
    }

    @Override
    public AuthorDTO create(AuthorDTO dto) {
        return null;
    }

    @Override
    public AuthorDTO update(Long id, AuthorDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
