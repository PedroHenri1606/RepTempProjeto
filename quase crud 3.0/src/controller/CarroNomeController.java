package controller;

import DAO.DaoCarroNome;
import model.CarroNome;

import java.util.List;

public class CarroNomeController {

    DaoCarroNome daoCarroNome = new DaoCarroNome();

    public void criarTabelaCarroNome(){ daoCarroNome.criarTabelaCarroNome(); }
    public CarroNome adicionar (CarroNome carroNome){ return daoCarroNome.adicionar(carroNome);}
    public List<CarroNome> listar(){ return daoCarroNome.listar();}
    public CarroNome retornarNome(long id){ return daoCarroNome.retornarNome(id);}
}
