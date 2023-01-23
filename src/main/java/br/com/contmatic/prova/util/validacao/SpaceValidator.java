package br.com.contmatic.prova.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SpaceValidator implements ConstraintValidator<Space, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.trim().length() > 0;
    }

}
