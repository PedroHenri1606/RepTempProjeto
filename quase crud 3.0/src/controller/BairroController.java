package controller;

import DAO.DaoBairro;
import model.Bairro;

import java.util.List;

public class BairroController {

    DaoBairro daoBairro = new DaoBairro();

    public void criarTabelaBairro(){ this.daoBairro.criaTabelaBairro();}
    public Bairro adicionar(Bairro bairro){ return this.daoBairro.adicionar(bairro);}
    public Bairro editar(Bairro bairro){ return this.daoBairro.editar(bairro);}
    public String escolherBairro(int id){ return this.daoBairro.escolherBairro(id);}
    public List<Bairro> listar(){ return this.daoBairro.listar();}
    public Bairro retornarDados(long id){ return this.daoBairro.retornarDados(id);}
    public String escolherBairro(long id){ return this.daoBairro.escolherBairro(id);}
    public long escolherbairroID(long id){ return this.daoBairro.escolherBairroID(id);}

}
