package com.figstudy.domain.books;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class BooksRepositoryTest {

    @Autowired
    BooksRepository booksRepository;

    @AfterEach
    public void cleanup() {
        booksRepository.deleteAll();
    }

    @Test
    public void 책저장_불러오기() {
        String title = "여행의 이유";
        String content = "여행 가고 싶어지는 책";

        booksRepository.save(Books.builder()
                .title(title)
                .content(content)
                .author("김영하")
                .build());

        //when
        List<Books> booksList = booksRepository.findAll();

        //then
        Books books = booksList.get(0);
        assertThat(books.getTitle()).isEqualTo(title);
        assertThat(books.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2024, 5, 1, 0, 0, 0);
        booksRepository.save(Books.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Books> postsList = booksRepository.findAll();

        //then
        Books books = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + books.getCreatedDate() + ", modifiedDate=" + books.getModifiedDate());

        assertThat(books.getCreatedDate()).isAfter(now);
        assertThat(books.getModifiedDate()).isAfter(now);
    }
}