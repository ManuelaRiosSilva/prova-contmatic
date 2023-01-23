package br.com.contmatic.prova.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DddValidator implements ConstraintValidator<Ddd, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.endsWith("0");
    }

}
