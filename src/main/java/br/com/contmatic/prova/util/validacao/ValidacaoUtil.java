package br.com.contmatic.prova.util.validacao;

public final class ValidacaoUtil {

    private ValidacaoUtil() {
        super();
    }

    public static final String REGEX_VALIDAR_NUMEROS = "[ a-zA-Z-à-úÀ-Ú]*";
    public static final String REGEX_VALIDAR_LETRAS = "[ 0-9]*";
    public static final String REGEX_VALIDAR_CARACTERES_ESPECIAIS = "[ 0-9a-zA-Z-à-úÀ-Ú]*";
    public static final String IP_REGEX = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.]+@[a-zA-Z0-9.]+$";
    
}
