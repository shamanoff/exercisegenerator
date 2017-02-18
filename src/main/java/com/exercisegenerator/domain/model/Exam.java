package com.exercisegenerator.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "exam", fetch = FetchType.EAGER)
    private List<Exercise> exercises;


}
