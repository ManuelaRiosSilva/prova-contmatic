package br.com.contmatic.prova.util;

import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Violations {
    
    private static ValidatorFactory factory = buildDefaultValidatorFactory();
    
    private static Validator validator = factory.getValidator();
    
    public static <T> Set<String> getErros(T prova){
        Set<String> erros = new HashSet<>();
        Set<ConstraintViolation<T>> violations = validator.validate(prova);
        violations.stream().forEach(violation -> erros.add(violation.getMessageTemplate()));
        return erros;
    }
}
