package com.example.book_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_management.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Page<Book> findByTitleLike(String title, Pageable pageable);
}
