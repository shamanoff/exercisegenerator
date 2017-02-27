package com.exercisegenerator.service;

import com.exercisegenerator.domain.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    @Override
    public List<Long> getAnswers(Long id) {
        List<Long> answersList = answerRepository.findAll(id);
        return answersList;
    }
}
