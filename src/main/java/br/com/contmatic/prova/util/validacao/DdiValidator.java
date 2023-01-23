package br.com.contmatic.prova.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DdiValidator implements ConstraintValidator<Ddi, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.equals("55");
    }
}
