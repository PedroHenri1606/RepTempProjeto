package view;

import controller.BairroController;
import model.Bairro;

import java.util.List;
import java.util.Scanner;

public class BairroView {

    BairroController bairroController = new BairroController();

    public void cadastrarBairro() {

        Bairro bairro = new Bairro();
        Scanner scan = new Scanner(System.in);

        System.out.print  (" Nome do bairro: "); bairro.setNome(scan.nextLine());
        System.out.println("==============================================\n");
        this.bairroController.adicionar(bairro);
    }

    public List<Bairro> visualizar() {
        List<Bairro> bairros = bairroController.listar();

        for (Bairro bairro : bairros) {
            System.out.println("|Id: " + bairro.getId() + "| Bairro: " + bairro.getNome());
        }
        return bairros;
    }

    public String escolherBairro(int escolha) {
        return bairroController.escolherBairro(escolha);
    }
}