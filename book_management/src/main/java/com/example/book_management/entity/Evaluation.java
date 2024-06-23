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
@Table(name = "evaluation")
@Data
public class Evaluation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "management_id")
    private Integer managementId;

    @Column(name = "evaluation")
    private Byte evaluation;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
