package controller;

import DAO.DaoCarroCor;
import model.Carro;
import model.CarroCor;

import java.util.List;

public class CarroCorController {

    DaoCarroCor daoCarroCor = new DaoCarroCor();

    public void criarTabelaCarroCor(){ daoCarroCor.criarTabelaCarroCor();}
    public CarroCor adicionar(CarroCor carroCor){ return daoCarroCor.adicionar(carroCor);}
    public List<CarroCor> listar (){ return daoCarroCor.listar();}
    public CarroCor retornarCor(long id){ return daoCarroCor.retornarCor(id);}
}
