package controller;

import DAO.DaoCarroFabricante;
import model.CarroFabricante;

import java.util.List;

public class CarroFabricanteController {

    DaoCarroFabricante daoCarroFabricante = new DaoCarroFabricante();

    public void criarTabelaCarroFabricante(){ daoCarroFabricante.criarTabelaCarroFabricante();}
    public CarroFabricante adicionar(CarroFabricante carroFabricante){ return daoCarroFabricante.adicionar(carroFabricante);}
    public List<CarroFabricante> listar(){ return daoCarroFabricante.listar();}
    public CarroFabricante retornarNome(long id){ return daoCarroFabricante.retornarNome(id);}

}
