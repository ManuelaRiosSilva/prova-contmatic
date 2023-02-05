package br.com.contmatic.prova.util.validacao;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UfValidator implements ConstraintValidator<Uf, String> {
    private List<String> valoresValidos;
    
    @Override
    public void initialize(Uf annotation) {
        valoresValidos = of(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .collect(toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && valoresValidos.contains(value);
    }

}
