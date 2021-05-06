package com.phutl.validator;


import com.phutl.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

public class WebAppValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;
    private Set<Validator> springValidators = new HashSet<>();
    @Override
    public boolean supports(Class<?> clazz) {

        return User.class.isAssignableFrom(clazz);

    }
    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations
                = beanValidator.validate(target);
        for (ConstraintViolation<Object> obj: constraintViolations)
            errors.rejectValue(obj.getPropertyPath().toString(),
                    obj.getMessageTemplate(), obj.getMessage());
        for (Validator obj: springValidators)
            obj.validate(target, errors);
    }
    public void setSpringValidators(
            Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
}
