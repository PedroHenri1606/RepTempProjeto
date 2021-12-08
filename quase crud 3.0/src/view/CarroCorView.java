package view;

import controller.CarroCorController;
import model.Carro;
import model.CarroCor;

import java.util.List;
import java.util.Scanner;

public class CarroCorView {

    CarroCor carroCor = new CarroCor();
    CarroCorController carroCorController = new CarroCorController();

    public void cadastrarCor(){

        Scanner scan = new Scanner(System.in);

        System.out.print(" Nome da Cor: "); carroCor.setNome(scan.nextLine());
        this.carroCorController.adicionar(carroCor);
    }

    public List<CarroCor> visualizarCor(){
        List <CarroCor> cores = carroCorController.listar();

        for (CarroCor cor: cores){
            System.out.println("|Id: " + cor.getId() + "| Cor: " + cor.getNome());
        }
        return cores;
    }
}

