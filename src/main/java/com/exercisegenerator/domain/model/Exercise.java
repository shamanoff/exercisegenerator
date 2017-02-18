package com.exercisegenerator.domain.model;

import com.exercisegenerator.domain.converter.MathActionConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "exercise")

public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long firstInt;
    @Column
    private Long secondInt;
    @Column
    @Convert(converter = MathActionConverter.class)
    private MathAction mathAction;
    @Column
    private Long correctResult;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examid")
    private Exam exam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conditionalid")
    private ExerciseCondition exerciseCondition;


    public boolean answerCheck(Long enteredResult) {
        return Objects.equals(enteredResult, correctResult);
    }
}
