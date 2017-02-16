package com.exercisegenerator.service;

import com.exercisegenerator.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ExamService {
    @Autowired
    private AdditionGenerator additionGenerator;

    List<Exercise> completeExam = new ArrayList<>();

    public void agregator(Set<Exercise> exerciseSet){

    }
}
