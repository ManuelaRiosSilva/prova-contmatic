package br.com.contmatic.prova.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class AgeValidator implements ConstraintValidator<Age, DateTime> {

    @Override
    public boolean isValid(DateTime value, ConstraintValidatorContext context) {
        Period period = new Period(value, DateTime.now());
        Integer anos = period.getYears();
        return anos != null && anos > 18 && anos < 70;
    }

}
