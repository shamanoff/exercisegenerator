package com.exercisegenerator.controller;

import com.exercisegenerator.domain.model.ConditionsWrapper;
import com.exercisegenerator.service.ExamGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExamController {
    @Autowired
    private ExamGenerator examGenerator;

    @RequestMapping(value = "/conditions", method = RequestMethod.POST)
    public String getConditions(@ModelAttribute("conditions") ConditionsWrapper conditions) {

        Long id = examGenerator.createExam(conditions.conditions);

        return "/quiz";
    }
}
