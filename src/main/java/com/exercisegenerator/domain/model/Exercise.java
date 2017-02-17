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
    private final Long firstInt;
    @Column
    private final Long secondInt;
    @Column
    @Convert(converter = MathActionConverter.class)
    private final MathAction mathAction;
    @Column
    private final Long correctResult;




    public boolean answerCheck(Long enteredResult) {
        return Objects.equals(enteredResult, correctResult);
    }
}
