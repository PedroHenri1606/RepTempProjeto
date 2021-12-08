package view;

import controller.CarroFabricanteController;
import model.CarroFabricante;

import java.util.List;
import java.util.Scanner;

public class CarroFabricanteView {

    CarroFabricanteController carroFabricanteController = new CarroFabricanteController();

    public void cadastrarFabricante(){

        CarroFabricante carroFabricante = new CarroFabricante();
        Scanner scan = new Scanner(System.in);

        System.out.print(" Nome do Fabricante: "); carroFabricante.setNome(scan.nextLine());
        this.carroFabricanteController.adicionar(carroFabricante);
    }

    public List<CarroFabricante>visualizarFabricante(){
        List <CarroFabricante> fabricantes = carroFabricanteController.listar();

        for (CarroFabricante fabricante: fabricantes){
            System.out.println("|Id: " + fabricante.getId() + "| Fabricante: " + fabricante.getNome());
        }
        return fabricantes;
    }
}
