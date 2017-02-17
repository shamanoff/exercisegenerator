package com.exercisegenerator.controller;

import com.exercisegenerator.domain.model.ExerciseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ExamController {

    @Autowired
    ExerciseCondition exCon;

    @PostMapping("/conditions")
    public ResponseEntity<Integer> conditionsList(List<ExerciseCondition> exCon){
        int examId = 0;



        return ResponseEntity.ok(examId);
    }
}
