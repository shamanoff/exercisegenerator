package com.exercisegenerator.controller;

import com.exercisegenerator.domain.model.ConditionsWrapper;
import com.exercisegenerator.service.ExamGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;

@Controller
public class ExamController {
    @Autowired
    private ExamGenerator examGenerator;

    @PostMapping(value = "/conditions")
    public ModelAndView getConditions(@ModelAttribute("conditions") ConditionsWrapper conditions) {

        Long id = examGenerator.createExam(conditions.conditions);

        return new ModelAndView("success", Collections.singletonMap("quizId", id));
    }
    @GetMapping(value = "/redirect")
    public View redirecter (Long id){
        View view = new RedirectView("/quiz/"+id);

        return view;

    }


}
