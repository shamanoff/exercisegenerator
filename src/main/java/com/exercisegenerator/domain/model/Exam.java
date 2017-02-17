package com.exercisegenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Column
    private final Long conditionId;
    @Column
    private final Long exerciseId;
    @Column
    private final Long userAnswer;

}