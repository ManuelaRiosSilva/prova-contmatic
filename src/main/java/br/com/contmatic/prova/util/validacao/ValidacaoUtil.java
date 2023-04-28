package br.com.contmatic.prova.util.validacao;

public final class ValidacaoUtil {

    private ValidacaoUtil() {
        super();
    }

    public static final String REGEX_PERMITIR_SOMENTE_LETRAS = "[ a-zA-Z-à-úÀ-Ú]*";
    public static final String REGEX_PERMITIR_SOMENTE_NUMEROS = "[ 0-9]*";
    public static final String IP_REGEX = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
    public static final String EMAIL_REGEX = "((?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]{1,65}(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|(\".+\")|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9.])?|localserver|((?!localhost)[0-9a-zA-Z:\\[\\]])*|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\]))"; 
}
