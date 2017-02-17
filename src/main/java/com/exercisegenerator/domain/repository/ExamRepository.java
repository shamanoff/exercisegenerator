package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {
}
