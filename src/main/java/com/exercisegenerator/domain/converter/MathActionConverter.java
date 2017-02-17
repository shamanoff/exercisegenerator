package com.exercisegenerator.domain.converter;

import com.exercisegenerator.domain.model.MathAction;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MathActionConverter implements AttributeConverter<MathAction, String>{


    @Override
    public String convertToDatabaseColumn(MathAction attribute) {
        return attribute == null ? null :attribute.getAction();
    }

    @Override
    public MathAction convertToEntityAttribute(String dbData) {
        return dbData == null ? null : MathAction.of(dbData);
    }
}
