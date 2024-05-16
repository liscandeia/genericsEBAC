package dao;

import domain.Carro;

public interface iCarrosDAO<C extends Carro> {
    public boolean cadastrarPedido(C carro);
    public C consultarPedidos(Long cpf);
}
