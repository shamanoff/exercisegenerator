package com.exercisegenerator.domain.model;

import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum MathAction {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String action;
    private final BiFunction<Long, Long, Long> calcFunction;

    MathAction(String action, BiFunction<Long, Long, Long> calcFunction) {
        this.action = action;
        this.calcFunction = calcFunction;
    }

    public static MathAction of(String action) {
        for (MathAction mathAction : values()) {
            if (mathAction.getAction().equals(action)) {
                return mathAction;
            }
        }
        throw new IllegalArgumentException("Action ot found");
    }

    public long apply(long a, long b) {
        return calcFunction.apply(a, b);
    }
}
