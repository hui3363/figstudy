package com.figstudy.web.dto;

import com.figstudy.domain.books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public BooksSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Books toEntity() {
        return Books.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
