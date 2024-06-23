package com.example.book_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book_management.entity.Book;
import com.example.book_management.repository.BookRepository;

@Controller
@RequestMapping("/detail")
public class DetailController {

	private final BookRepository bookRepository;

	public DetailController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/{id}")
	public String showDetailPage(@PathVariable(name = "id") Integer id, Model model) {
		Book book = bookRepository.getReferenceById(id);
		System.out.println("id = " + id + " title =" + book.getTitle());

		model.addAttribute("book", book);
		return "detail";

	}
}
