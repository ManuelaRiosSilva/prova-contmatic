package br.com.contmatic.prova.util.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public final class DataUtil {

	private DataUtil() {
		super();
	}
	
	public static void validarDataMaxima(LocalDateTime data, String mensagem) {
		if(data.isAfter(LocalDateTime.now())) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarDataMaxima(LocalDate data, String mensagem) {
		if(data.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarDataNascimentoMinima(LocalDate data, String mensagem) {
		Period periodo = Period.between(data, LocalDate.now());
		int anos = periodo.getYears();
		
		if(anos < 18) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarDataNascimentoMaxima(LocalDate data, String mensagem) {
		Period periodo = Period.between(data, LocalDate.now());
		int anos = periodo.getYears();
		
		if(anos > 70) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarDataAtualizacaoMinima(LocalDateTime dataAtt, LocalDateTime dataCri, String mensagem) {
		if(dataAtt.isBefore(dataCri)) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
