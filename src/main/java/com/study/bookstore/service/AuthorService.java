package com.study.bookstore.service;

import com.study.bookstore.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO getById(Long id);
    List<AuthorDTO> getAll();
    AuthorDTO create(AuthorDTO dto);
    AuthorDTO update(Long id, AuthorDTO dto);
    void delete(Long id);
}
