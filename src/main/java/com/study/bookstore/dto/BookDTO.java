package com.study.bookstore.dto;

public record BookDTO(
        String title,
        Long authorId,
        Integer year,
        String isbn,
        Double price) {
}
