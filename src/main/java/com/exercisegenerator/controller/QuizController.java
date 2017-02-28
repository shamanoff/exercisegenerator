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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView getQuizById(@PathVariable Long id) {

        if(quizService.isSolved(id)){
            return new ModelAndView("redirect:/frozen/"+id);
        }

        ModelAndView mv = getModelAndView(id, "quiz");

        return mv;
    }

    @PostMapping("/complete/{id}")
    public View complete(@PathVariable Long id){
      quizService.solveQuiz(id);
      return new RedirectView("/frozen/"+id);
    }

    @GetMapping("/frozen/{id}")
    public ModelAndView getFrozenById(@PathVariable Long id) {

        ModelAndView mv = getModelAndView(id, "frozen");

        return mv;
    }

    private ModelAndView getModelAndView(Long examId, String viewName) {
        Map<MathAction, List<Exercise>> exerciseMap = quizService.getExerciseMap(examId);
        List<Exercise> add = exerciseMap.get(ADDITION);
        List<Exercise> sub = exerciseMap.get(SUBTRACTION);
        List<Exercise> mul = exerciseMap.get(MULTIPLICATION);
        List<Exercise> divi = exerciseMap.get(DIVISION);

        ModelAndView mv = new ModelAndView(viewName);
        mv.addObject("add", add);
        mv.addObject("sub", sub);
        mv.addObject("mul", mul);
        mv.addObject("divi", divi);
        mv.addObject("examId", examId );
        return mv;
    }


    @PostMapping("/quiz/check/{exerciseId}")
    public ResponseEntity<Long> checkAnswer(@RequestParam("answer") Long answer, @PathVariable Long exerciseId) {
        Exercise exercise = exerciseRepository.findOne(exerciseId);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAnswer(answer);
        userAnswer.setExerciseid(exercise.getId());
        answerRepository.save(userAnswer);
        if (exercise.answerCheck(answer)) {
            return ResponseEntity.ok(exercise.getCorrectResult());
        }
        return ResponseEntity.badRequest().body(exercise.getCorrectResult());


    }


}
