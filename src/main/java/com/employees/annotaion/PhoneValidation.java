package com.employees.annotaion;

import com.employees.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidation implements ConstraintValidator<Phone,String> {

    @Autowired
    private UserService userService;


    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        try
        {
            if(s.length()<9){
                return false;
            }else return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return true;
        }
    }
}
