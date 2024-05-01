package com.figstudy.web.dto;

import com.figstudy.domain.books.Books;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BooksListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public BooksListResponseDto(Books entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        //this.modifiedDate = entity.getModifiedDate();
    }
}
