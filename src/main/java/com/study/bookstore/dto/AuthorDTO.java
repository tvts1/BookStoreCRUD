package com.study.bookstore.dto;

import java.util.List;

public record AuthorDTO(
        String name,
        List<BookDTO> books
) {}
