package view;

import controller.CarroNomeController;
import model.Carro;
import model.CarroCor;
import model.CarroNome;

import java.util.List;
import java.util.Scanner;

public class CarroNomeView {

    CarroNomeController carroNomeController = new CarroNomeController();
    CarroNome carroNome = new CarroNome();

    public void cadastrarNome(){

        Scanner scan = new Scanner(System.in);
        System.out.print(" Nome do carro: "); carroNome.setNome(scan.nextLine());
        this.carroNomeController.adicionar(carroNome);
    }

    public List<CarroNome> visualizarNome(){
        List <CarroNome> modelos = carroNomeController.listar();

        for (CarroNome modelo: modelos){
            System.out.println("|Id: " + modelo.getId() + "| Modelo: " + modelo.getNome());
        }
        return modelos;
    }

}
