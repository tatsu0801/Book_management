package com.example.book_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_management.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

}
