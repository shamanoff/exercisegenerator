package com.exercisegenerator.controller;

import com.exercisegenerator.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;


    @RequestMapping("/product/{id}")
    public ModelAndView getQuizById(@PathVariable Integer id, Model model) {

        ModelAndView mv = new ModelAndView("quiz");
        mv.addObject("exMap",quizService.getExMap().get("ADDITION"));
        model.addAttribute("quiz", quizService.getExercise(id));
        return mv;
    }
}
