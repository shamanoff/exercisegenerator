package com.exercisegenerator.controller;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.MathAction;
import com.exercisegenerator.domain.model.UserAnswer;
import com.exercisegenerator.domain.repository.AnswerRepository;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import com.exercisegenerator.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.exercisegenerator.domain.model.MathAction.*;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/quiz/{id}")
    public ModelAndView getQuizById(@PathVariable Long id, Model model) {

        Map<MathAction, List<Exercise>> exerciseMap = quizService.getExerciseMap(id);
        List<Exercise> add = exerciseMap.get(ADDITION);
        List<Exercise> sub = exerciseMap.get(SUBTRACTION);
        List<Exercise> mul = exerciseMap.get(MULTIPLICATION);
        List<Exercise> divi = exerciseMap.get(DIVISION);

        ModelAndView mv = new ModelAndView("quiz");
        mv.addObject("add", add);
        mv.addObject("sub", sub);
        mv.addObject("mul", mul);
        mv.addObject("divi", divi);

//        model.addAttribute("quiz", quizService.getExercise(id));
        return mv;
    }

    //todo:создать репозиторий для сохранения введенных ответов в базу. и записать в этом же методе введенный ответ.

    @PostMapping("/quiz/check/{exerciseId}")
    public ResponseEntity<Long> checkAnswer(@RequestParam("answer") Long answer, @PathVariable Long exerciseId) {
        Exercise exercise = exerciseRepository.findOne(exerciseId);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAnswer(answer);
        userAnswer.setExercise(exercise);
        answerRepository.save(userAnswer);
        if (exercise.answerCheck(answer)) {
            return ResponseEntity.ok(exercise.getCorrectResult());
        }
        return ResponseEntity.badRequest().body(exercise.getCorrectResult());


    }


}
