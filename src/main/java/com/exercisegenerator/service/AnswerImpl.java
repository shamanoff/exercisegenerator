package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.UserAnswer;
import com.exercisegenerator.domain.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    @Override
    public List<Long> getAnswers(Long id) {
        List<UserAnswer> answersList = answerRepository.findAllByExerciseId(id);

        return answersList.stream()
                .map(UserAnswer::getAnswer)
                .collect(Collectors.toList());
    }
}
