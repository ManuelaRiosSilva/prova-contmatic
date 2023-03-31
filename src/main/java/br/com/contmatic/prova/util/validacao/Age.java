package br.com.contmatic.prova.util.validacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Coloque em um atributo de data para verificar a maioridade de uma pessoa. 
 * <p>
 * Utiliza a biblioteca Joda Time para realizar os cálculos
 * <p>
 * O cálculo é feito a partir da subtração da data atual com a data passada no atributo.
 * <p>
 * Considera como maior de idade pessoas que possuem entre 18 e 70 anos.
 * 
 * @author Manuela Rios
 * @param Mensagem de erro em caso de falha
 */
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {   
    /**
     * @return
     */
    String message() default "{message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
