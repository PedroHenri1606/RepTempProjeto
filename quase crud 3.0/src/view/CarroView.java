package view;

import DAO.DaoCarroFabricante;
import controller.CarroController;
import controller.CarroCorController;
import controller.CarroFabricanteController;
import controller.CarroNomeController;
import model.Bairro;
import model.Carro;
import model.CarroFabricante;
import model.CarroNome;
import model.CarroCor;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class CarroView {

    CarroNomeView carroNomeView = new CarroNomeView();
    CarroController carroController = new CarroController();
    CarroFabricanteController carroFabricanteController = new CarroFabricanteController();
    CarroFabricanteView carroFabricanteView = new CarroFabricanteView();
    CarroCorController carroCorController = new CarroCorController();
    CarroCorView carroCorView = new CarroCorView();
    CarroNomeController carroNomeController = new CarroNomeController();
    Scanner scan = new Scanner(System.in);

    public Carro cadastrarCarro(){

        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);

            carro.setFabricante(this.escolhendoFabricante());
            carro.setNome(this.escolhendoNomeCarro());
            carro.setCor(this.escolhendoCor());
            System.out.print(" Ano de fabricação: "); carro.setAno(scan.nextLong());
            String tmp1 = scan.nextLine();
            System.out.print(" Placa do carro: "); carro.setPlaca(scan.nextLine());
            System.out.println("==============================================\n");
            this.carroController.cadastrarCarro(carro);
            return carro;
    }

    public CarroNome escolhendoNomeCarro(){

        while (true) {
            System.out.println("==============================================");
            carroNomeView.visualizarNome();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar novo Modelo");
            System.out.println("       [2] - Escolher um Modelo");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> this.cadastrarNomeCarro();
                case 2 -> {return this.escolherNomeCarro();}
            }
        }
    }

    public CarroNome escolherNomeCarro() {

        System.out.println("==============================================");
        System.out.print  ("Informe Modelo escolhido: "); long idCarro = Long.parseLong(scan.nextLine());
        return carroNomeController.retornarNome(idCarro);
    }

    public void cadastrarNomeCarro(){
        this.carroNomeView.cadastrarNome();
    }

    public CarroFabricante escolhendoFabricante(){

        while (true) {
            System.out.println("==============================================");
            carroFabricanteView.visualizarFabricante();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar nova Fabricante");
            System.out.println("       [2] - Escolher uma Fabricante");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> this.cadastrarFabricante();
                case 2 -> {return this.escolherFabricante();}
            }
        }
    }

    public CarroFabricante escolherFabricante() {

        System.out.println("==============================================");
        System.out.print  ("Informe Fabricante escolhido: "); long idFabricante = Long.parseLong(scan.nextLine());
        return carroFabricanteController.retornarNome(idFabricante);
    }

    public void cadastrarFabricante(){
        this.carroFabricanteView.cadastrarFabricante();
    }

    public CarroCor escolhendoCor(){

        while (true) {
            System.out.println("==============================================");
            carroCorView.visualizarCor();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar nova Cor");
            System.out.println("       [2] - Escolher uma Cor");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> this.cadastrarCor();
                case 2 -> {return this.escolherCor();}
            }
        }
    }

    public CarroCor escolherCor() {

        System.out.println("==============================================");
        System.out.print  ("Informe Cor escolhido: "); long idCor = Long.parseLong(scan.nextLine());
        return carroCorController.retornarCor(idCor);
    }

    public void cadastrarCor(){
        this.carroCorView.cadastrarCor();
    }


}


