package com.exercisegenerator.model;

import lombok.Getter;

@Getter
public enum MathAction {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

  private String action;

    MathAction(String action) {
        this.action = action;
    }
}
