package com.example.book_management.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book_management.entity.Book;
import com.example.book_management.repository.BookRepository;

@Controller
public class HomeController {
	private final BookRepository bookRepository;

	public HomeController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public String home(Model model, Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {
		System.out.println(keyword);
		Page<Book> books;

		if (keyword != null) {
			books = bookRepository.findByTitleLike("%" + keyword + "%", pageable);

		} else {
			books = bookRepository.findAll(pageable);
		}

		model.addAttribute("books", books);
		System.out.println(books.getTotalElements());
		return "home";
	}
}