package com.musicDB.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinimumAgeValidator.class)
@Documented
public @interface OverAge {

    public int value() default 18;

    String message() default "Age must be over the specified value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
