package controller;

import DAO.DAOFaculdade;
import model.Faculdade;

import java.util.List;

public class FaculdadeController {
    DAOFaculdade daoFaculdade = new DAOFaculdade();
    public void SalvarFaculdade(Faculdade faculdade) {
        daoFaculdade.cadastrarFaculdade(faculdade);
    }
    public List<Faculdade> listarFaculdade() {
        return daoFaculdade.listarFaculdade();
    }
    public void criarTabelaFaculdade(){  daoFaculdade.criarTabelaFaculdade();}
}
