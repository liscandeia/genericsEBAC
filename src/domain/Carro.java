package domain;

import java.util.Objects;

public abstract class Carro {
    @Override
    public String toString() {
        return "Carro{" +
                "modelo=" + modelo +
                ", cor='" + cor + '\'' +
                ", completo=" + completo +
                ", cpf=" + cpf +
                '}';
    }

    public Integer getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public Boolean getCompleto() {
        return completo;
    }

    public Long getCpf() {
        return cpf;
    }

    private Integer modelo;
    private String cor;
    private Boolean completo;
    private Long cpf;


    public Carro(Integer modelo, String cor, Boolean completo, Long cpf) {
        this.modelo = modelo;
        this.cor = cor;
        this.completo = completo;
        this.cpf = cpf;
    }
    public abstract Boolean isModeloCarro();
    public  Long getCodigo(){
        return cpf;
    };

  //
}
