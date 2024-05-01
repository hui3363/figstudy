package com.figstudy.web.dto;

import com.figstudy.domain.books.Books;
import lombok.Getter;

@Getter
public class BooksResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public BooksResponseDto(Books entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
