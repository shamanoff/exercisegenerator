package com.exercisegenerator.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "answer")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column
    private final Long exerciseId;

    @Column
    private final Long answer;
}
