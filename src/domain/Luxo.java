package domain;

public class Luxo extends Carro{


    public Luxo( Integer modelo, String cor, Boolean completo, Long cpf) {
        super(modelo, cor, completo, cpf);
    }

    public Boolean getGarantia() {
        return garantia;
    }

    private Boolean garantia = true;


    @Override
    public Boolean isModeloCarro() {
        return getModelo() == 1 || getModelo() == 2;
    }
    @Override
    public String toString() {
        return "Luxo{" +
                "cpfCadastrado=" + getCpf() +
                "modelo=" + getModelo()+
                "garantia=" + getGarantia()+
                '}';
    }


}
