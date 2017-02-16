package com.exercisegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exercise")
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private int firstInt;
    @Column
    private final int secondInt;
    @Column
    private final String mathAction;
    @Column
    private final int correctResult;
    @Column
    private int enteredResult;



    public boolean answerCheck(int enteredResult, int correctResult){
        return enteredResult == correctResult;
    }
}
