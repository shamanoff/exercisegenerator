package com.exercisegenerator.service;

import com.exercisegenerator.domain.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    @Override
    public List<Long> getAnswers(Long id) {
        List<Long> answersList = answerRepository.findAllByExerciseid(id);
        return answersList;
       /* return answersList.stream()
                .map(UserAnswer::getAnswer)
                .collect(Collectors.toList());*/
    }
}
