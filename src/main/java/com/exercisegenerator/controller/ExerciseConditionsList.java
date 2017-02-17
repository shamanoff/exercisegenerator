package com.exercisegenerator.controller;

import com.exercisegenerator.model.ExerciseConditions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExerciseConditionsList {


    @PostMapping("/conditions")
    public ResponseEntity<Integer> conditionsList(List<ExerciseConditions> exCon){
        int examId = 0;



        return ResponseEntity.ok(examId);
    }
}
