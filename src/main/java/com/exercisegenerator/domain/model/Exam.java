package com.exercisegenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "exam")
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    private Long id;
    @OneToMany(mappedBy = "exam", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    @Column(name = "issolved")
    private boolean isSolved;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                '}';
    }
}
