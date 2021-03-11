package com.musicDB.validators;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class MinimumAgeValidator implements ConstraintValidator<OverAge, Date> {
    private int minimumAge;

    public void initialize(OverAge constraint) {
        this.minimumAge = constraint.value();
    }

    public boolean isValid(Date value, ConstraintValidatorContext context) {
        LocalDate currentDate = LocalDate.now();
        LocalDate otherDate = LocalDate.ofInstant(value.toInstant(), ZoneId.systemDefault());
        int years = Period.between(otherDate, currentDate).getYears();

        return years > minimumAge;
    }
}


