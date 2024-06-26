package com.example.book_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_management.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Page<Book> findByTitleLike(String title, Pageable pageable);

	public Page<Book> findByPublisherName(String title, Pageable pageable);

	public Page<Book> findByTitleLikeOrderByTitle(String title, Pageable pageable);

	public Page<Book> findByTitleLikeOrderByAuthorName(String title, Pageable pageable);

	public Page<Book> findByTitleLikeOrderByPublisherName(String title, Pageable pageable);
}
