package com.thai.spring_mvc.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

    private static final String PHONE_PATTERN = "^(0[3|5|7|8|9])+([0-9]{8})$";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null) {
            return false;
        }
        return s.matches(PHONE_PATTERN);
    }
}
