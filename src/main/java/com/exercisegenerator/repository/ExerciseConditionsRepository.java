package com.exercisegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.locks.Condition;

public interface ExerciseConditionsRepository extends JpaRepository<Condition, Long> {
}
