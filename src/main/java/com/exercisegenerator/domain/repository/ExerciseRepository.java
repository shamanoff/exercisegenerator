package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findByExamId(Integer id);

}
