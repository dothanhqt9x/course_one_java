package com.thai.spring_mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    private static final String NAME_PATTERN = "^[a-zA-Z ]{6,}$";

    @Override
    public void initialize(NameConstraint constraintAnnotation) {
        // không cần init gì thêm
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // nếu null, không hợp lệ
        }
        return value.matches(NAME_PATTERN);
    }
}
