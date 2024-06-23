package com.example.book_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book_management.entity.Book;
import com.example.book_management.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional
	public void create(String title, String numberOfTurns, String authorName, String publisherName, String titleKana,
			String authorNameKana) {
		Book book = new Book();
		book.setTitle(title);
		book.setNumberOfTurns(Integer.valueOf(numberOfTurns));
		book.setAuthorName(authorName);
		book.setPublisherName(publisherName);
		book.setTitleKana(titleKana);
		book.setAuthorNameKana(authorNameKana);

		bookRepository.save(book);
	}
}