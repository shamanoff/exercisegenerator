package com.exercisegenerator.controller;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;


    @RequestMapping("/quiz/{id}")
    public ModelAndView getQuizById(@PathVariable Long id, Model model) {

        List<Exercise> add = quizService.getExerciseMap().get("ADDITION");
        List<Exercise> sub = quizService.getExerciseMap().get("SUBTRACTION");
        List<Exercise> mul = quizService.getExerciseMap().get("MULTIPLICATION");
        List<Exercise> divi = quizService.getExerciseMap().get("DIVISION");

        ModelAndView mv = new ModelAndView("quiz");
        mv.addObject("add",add);
        mv.addObject("sub",sub);
        mv.addObject("mul",mul);
        mv.addObject("divi",divi);
       /* mv.addObject("exMap",mul);
        mv.addObject("exMap",div);*/
      /*   mv.addObject("exMap",quizService.getExerciseMap().get("ADDITION"));
       mv.addObject("exMap",quizService.getExerciseMap().get("SUBTRACTION"));
        mv.addObject("exMap",quizService.getExerciseMap().get("MULTIPLICATION"));
        mv.addObject("exMap",quizService.getExerciseMap().get("DIVISION"));*/
        model.addAttribute("quiz", quizService.getExercise(id));
        return mv;
    }
}
