package domain;

public class Antigo extends Carro{


    public Antigo(Integer modelo, String cor, Boolean completo, Long cpf) {
        super(modelo, cor, completo, cpf);
    }

    public Boolean getRevisao() {
        return revisao;
    }

    private Boolean revisao = true;


    @Override
    public Boolean isModeloCarro() {
        return getModelo() == 3 || getModelo() == 4;
    }
    @Override
    public String toString() {
        return "Antigo{" +
                "cpfCadastrado=" + getCpf() +
                "modelo=" + getModelo()+
                "revisao" + getRevisao()+
                '}';
    }
}
