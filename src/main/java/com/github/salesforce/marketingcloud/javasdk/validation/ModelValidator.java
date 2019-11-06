package com.github.salesforce.marketingcloud.javasdk.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ModelValidator {
    public Set<ConstraintViolation<Object>> validate(Object obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Object>> violationSet = factory.getValidator().validate(obj);
        return violationSet;
    }
}
