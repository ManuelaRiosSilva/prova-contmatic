package br.com.contmatic.prova.telefone;

public enum TelefoneType {
    CELULAR("Celular"),
    COMERCIAL("Comercial"),
    RESIDENCIAL("Residencial");
    
    private String telefone;
    private TelefoneType(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }
}
