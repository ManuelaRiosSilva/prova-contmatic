package br.com.contmatic.prova.endereco;

public enum EstadoType {
    SP("São Paulo");

    private String estado;
    private EstadoType(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }   
    
}
