package dao;

import domain.Carro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrosDAO<C extends Carro> implements iCarrosDAO<C> {
    private Map<Long, C> mapaCarros;

    public CarrosDAO() {
        this.mapaCarros = new HashMap<>();
    }

    @Override
    public boolean cadastrarPedido(C carro) {
        Long cpf = carro.getCpf();
        if (mapaCarros.containsKey(cpf)) {
            return false; // Já existe um carro com esse CPF
        }
        mapaCarros.put(cpf, carro);
        return true;
    }

    @Override
    public C consultarPedidos(Long cpf) {
        return mapaCarros.get(cpf);
    }
}
