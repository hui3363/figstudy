package com.figstudy.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query("SELECT p FROM Books p ORDER BY p.id DESC")
    List<Books> findAllOrderByIdDesc();
}