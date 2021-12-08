package view;

import controller.FaculdadeController;
import model.Faculdade;

import java.util.List;
import java.util.Scanner;

public class FaculdadeView {
    FaculdadeController faculdadeController = new FaculdadeController();
    public void cadastrar() {

        Scanner scanner = new Scanner(System.in);
        Faculdade faculdade = new Faculdade();

        System.out.println("==============================================");
        System.out.print  ("Digite a faculdade: "); faculdade.setNome(scanner.nextLine());
        faculdadeController.SalvarFaculdade(faculdade);
    }

    public Faculdade selecionarFaculdade() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("==============================================");
            List<Faculdade> faculdades = faculdadeController.listarFaculdade();
            for (int i = 0; i<faculdades.size(); i++) {
                System.out.println(faculdades.get(i).toString());
            }
            System.out.println("==============================================");
            System.out.print  ("Selecione o id: ");  long tmp = Long.parseLong(scanner.nextLine());
            System.out.println("==============================================");
            for (int i = 0; i< faculdades.size(); i++) {
                if (faculdades.get(i).getIdFaculdade() == tmp) {
                    return faculdades.get(i);
                }
            }
            System.out.println("         Nenhuma Opçao valida");
            System.out.println("==============================================");
        }
    }

    public List<Faculdade> listarFaculdades(){
        List<Faculdade> faculdades = faculdadeController.listarFaculdade();
        for (Faculdade faculdade: faculdades){
            System.out.println("|Id: " + faculdade.getIdFaculdade() + " | Faculdade: " + faculdade.getNome());
        }
        return faculdades;
    }
}
