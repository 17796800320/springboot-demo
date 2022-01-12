package com.tm.utils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCard, Object> {


    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            if (value.toString().length()!=6){
                return false;
            }
            Integer.valueOf(value.toString());
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
