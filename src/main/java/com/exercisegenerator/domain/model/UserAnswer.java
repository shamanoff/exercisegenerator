package com.exercisegenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "useranswer")
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "exerciseid", updatable = false)*/
    @Column
    private Long exerciseid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exerciseid", updatable = false, insertable = false)
    private Exercise exercise;

    @Column
    private Long answer;

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", exerciseid=" + exerciseid +
                ", answer=" + answer +
                '}';
    }
}
