package br.com.contmatic.prova.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalDate;
import org.joda.time.Period;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Period period = new Period(value, LocalDate.now());
        Integer anos = period.getYears();
        return anos != null && anos >= 18 && anos <= 70;
    }
}

