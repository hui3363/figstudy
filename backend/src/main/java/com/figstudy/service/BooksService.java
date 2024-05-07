package com.figstudy.service;

import com.figstudy.domain.books.Books;
import com.figstudy.domain.books.BooksRepository;
import com.figstudy.web.dto.BooksListResponseDto;
import com.figstudy.web.dto.BooksResponseDto;
import com.figstudy.web.dto.BooksSaveRequestDto;
import com.figstudy.web.dto.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Transactional
    public Long save(BooksSaveRequestDto requestDto) {
        return booksRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BooksUpdateRequestDto requestDto) {
        Books posts = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        booksRepository.delete(books);
    }

    @Transactional(readOnly = true)
    public BooksResponseDto findById(Long id) {
        Books entity = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new BooksResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BooksListResponseDto> findAllDesc() {
        return booksRepository.findAllOrderByIdDesc().stream()
                .map(BooksListResponseDto::new)
                .collect(Collectors.toList());
    }
}