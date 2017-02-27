package com.exercisegenerator.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "answer")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exerciseId", insertable = false, updatable = false)
    private  Exercise exercise;

    @Column
    private  Long answer;

}
