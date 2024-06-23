package com.example.book_management.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_information")
@Data
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "management_id")
    private Integer managementId;

    @Column(name = "title")
    private String title;

    @Column(name = "title_kana")
    private String titleKana;

    @Column(name = "number_of_turns")
    private Integer numberOfTurns;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_name_kana")
    private String authorNameKana;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}

