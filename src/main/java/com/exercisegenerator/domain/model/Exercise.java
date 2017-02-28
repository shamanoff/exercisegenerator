package com.exercisegenerator.domain.model;

import com.exercisegenerator.domain.converter.MathActionConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "exercise")
@Accessors(chain = true)
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstint")
    private Long firstInt;
    @Column(name = "secondint")
    private Long secondInt;
    @Column(name = "mathaction")
    @Convert(converter = MathActionConverter.class)
    private MathAction mathAction;
    @Column(name = "correctresult")
    private Long correctResult;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "examid", insertable = false, updatable = false)
    private Exam exam;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "conditionalid")
    private ExerciseCondition exerciseCondition;
    @Column(name = "examid")
    private Long examId;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<UserAnswer> userAnswers;

    public Exercise(Long firstInt, Long secondInt, MathAction mathAction, Long correctResult) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.mathAction = mathAction;
        this.correctResult = correctResult;
    }

    public boolean answerCheck(Long enteredResult) {
        return Objects.equals(enteredResult, correctResult);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", firstInt=" + firstInt +
                ", secondInt=" + secondInt +
                ", correctResult=" + correctResult +
                ", examId=" + examId +
                '}';
    }
}
