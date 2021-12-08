package controller;

import DAO.DaoCarro;
import model.Carro;

import java.util.List;

public class CarroController {

    DaoCarro daoCarro = new DaoCarro();

    public void criarTabelaCarro(){ daoCarro.criarTabelaCarro();}
    public Carro cadastrarCarro(Carro carro){ return daoCarro.adicionar(carro);}
    //public List<Carro> listarCarro(){ return daoCarro.listar();}
    public Carro retornarDados(long id){ return daoCarro.retornarDados(id);}
    public Carro retornarCarro(long id){ return daoCarro.retornarCarro(id);}
    public String retornarNome(long id){ return daoCarro.retornarNome(id);}

}
