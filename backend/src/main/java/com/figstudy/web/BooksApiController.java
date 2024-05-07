package com.figstudy.web;

import com.figstudy.service.BooksService;
import com.figstudy.web.dto.BooksListResponseDto;
import com.figstudy.web.dto.BooksResponseDto;
import com.figstudy.web.dto.BooksSaveRequestDto;
import com.figstudy.web.dto.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BooksApiController {

    private final BooksService booksService;

    @PostMapping("/api/v1/books")
    public Long save(@RequestBody BooksSaveRequestDto requestDto) {
        return booksService.save(requestDto);
    }

    @PutMapping("/api/v1/books/{id}")
    public Long update(@PathVariable Long id, @RequestBody BooksUpdateRequestDto requestDto) {
        return booksService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/books/{id}")
    public Long delete(@PathVariable Long id) {
        booksService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/books/{id}")
    public BooksResponseDto findById(@PathVariable Long id) {
        return booksService.findById(id);
    }

    @GetMapping("/api/v1/books/list")
    public List<BooksListResponseDto> findAll() {
        return booksService.findAllDesc();
    }
}