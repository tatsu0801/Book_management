package com.example.book_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book_management.service.BookService;

@Controller
@RequestMapping("/add")
public class AddController {

	private final BookService bookService;

	public AddController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public String showAddPage() {
		return "add";
	}

	@PostMapping("/create")
	public String create(@RequestParam(name = "title", required = true) String title,
			@RequestParam(name = "number_of_turns", required = true) String numberOfTurns,
			@RequestParam(name = "author_name", required = true) String authorName,
			@RequestParam(name = "publisher_name", required = true) String publisherName,
			@RequestParam(name = "title_kana", required = true) String titleKana,
			@RequestParam(name = "author_name_kana", required = true) String authorNameKana) {
		System.out.println("title =" + title);
		System.out.println("number_of_turns =" + numberOfTurns);
		System.out.println("author_name =" + authorName);
		System.out.println("publisher_name =" + publisherName);
		System.out.println("title_kana =" + titleKana);
		System.out.println("author_name_kana =" + authorNameKana);

		bookService.create(title, numberOfTurns, authorName, publisherName, titleKana, authorNameKana);

		return "redirect:/";

	}
}