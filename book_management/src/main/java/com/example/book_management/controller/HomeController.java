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
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "order", required = false) String order) {
		System.out.println("検索ワード = " + keyword + ", 並び順 =" + order);
		Page<Book> books;

		if (keyword != null) {
			books = bookRepository.findByTitleLike("%" + keyword + "%", pageable);
		} else {
			if (order == null) {
				books = bookRepository.findAll(pageable);
			} else if (order.equals("title")) {
				books = bookRepository.findByTitleLikeOrderByTitle("%%", pageable);
			} else if (order.equals("author")) {
				books = bookRepository.findByTitleLikeOrderByAuthorName("%%", pageable);
			} else if (order.equals("publisher")) {
				books = bookRepository.findByTitleLikeOrderByPublisherName("%%", pageable);
			} else {
				books = bookRepository.findAll(pageable);
			}

		}

		model.addAttribute("books", books);
		System.out.println(books.getTotalElements());
		return "home";
	}
}