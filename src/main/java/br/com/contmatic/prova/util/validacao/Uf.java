package br.com.contmatic.prova.util.validacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Valida se a UF inserida é válida.
 *<p>
 *Retorna falso caso a UF não exista ou não pertença ao Brasil.
 *<p>
 *O atributo anotado deve ser do tipo String. 
 *<p>
 *@author Manuela Rios
 *@param Classe que contém todas as UF brasileiras
 *@param Mensagem de erro em caso de falha
 */
 @Retention(RUNTIME)
 @Target({ FIELD, PARAMETER })
 @Constraint(validatedBy = { UfValidator.class })
 
 public @interface Uf {

    String message() default "{message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    Class<? extends java.lang.Enum<?>> enumClass();
}

