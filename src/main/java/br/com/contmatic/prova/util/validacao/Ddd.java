package br.com.contmatic.prova.util.validacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Valida se o DDD termina com 0.
 * <p>
 * No Brasil, números de DDD terminados em 0 são reservados e não podem ser utilizados.
 * <p>
 * O atributo anotado deve ser do tipo String. 
 * <p>
 * @author Manuela Rios
 * @param Mensagem de erro em caso de falha.
 */
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy = DddValidator.class)
public @interface Ddd {
    
    String message() default "{message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
