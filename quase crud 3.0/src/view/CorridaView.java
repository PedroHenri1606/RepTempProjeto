package view;

import controller.CarroController;
import controller.CorridaController;
import model.Corrida;
import model.Usuario;

import java.util.*;

public class CorridaView {

    CorridaController corridaController = new CorridaController();
    Scanner scan = new Scanner(System.in);

    public void visualizarMinhasCorrida(Usuario usuario) {
        List<Corrida> corridas = corridaController.visualizar(usuario);
        System.out.println("==============================================");
        for (Corrida corrida : corridas) {
            System.out.println("Id: "+ corrida.getIdCorrida());
            System.out.println("Criador: " + corrida.getUser());
            System.out.println("Data: " + corrida.getDia()+ "/" + corrida.getMes() + "/" + corrida.getAno());
            System.out.println("Carro: " + corrida.getCarro());
            System.out.println("Preço: R$" + corrida.getPreco());
            System.out.println("==============================================");

        }
    }

    public void visualizarCorridasPendentes() {
        List<Corrida> corridas = corridaController.visualizarPendentes();
        System.out.println("==============================================");
        for (Corrida corrida : corridas) {
            System.out.println("Id: "+ corrida.getIdCorrida());
            System.out.println("Data: " + corrida.getDia()+ "/" + corrida.getMes() + "/" + corrida.getAno());
            System.out.println("Carro: " + corrida.getCarro());
            System.out.println("Preço: R$" + corrida.getPreco());
            System.out.println("==============================================");

        }

    }

    public void cadastrarCorrida(Usuario usuario) {
        Corrida corrida = new Corrida();
        System.out.println("==============================================");
        System.out.print  ("Horario da corrida: "); corrida.setHora(scan.nextLine());
        System.out.print  ("Dia da corrida: ");     corrida.setDia(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Mês da corrida: ");     corrida.setMes(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Ano da corrida: ");     corrida.setAno(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Preço da corrida: ");   corrida.setPreco(Double.parseDouble(scan.nextLine()));
        corrida.setCarro(usuario.getCarro());
        corrida.setUser(usuario);
        System.out.println("==============================================\n");
        corridaController.cadastrarCorrida(corrida);
    }

    public void escolherCorrida(Usuario usuario) {
        this.visualizarMinhasCorrida(usuario);
        System.out.print  ("Digite o id da corrida: "); long idCorrida = Long.parseLong(scan.nextLine());
        Corrida corridaAtual = corridaController.determinarCorridaAtual(idCorrida, usuario);
        this.menuCorrida(corridaAtual, usuario);
    }

    public void escolherCorridaPassageiro(Usuario usuario) {
        System.out.print  ("Digite o id da corrida: "); long idCorrida = Long.parseLong(scan.nextLine());
        Corrida corridaAtual = corridaController.determinarCorridaAtual(idCorrida, usuario);
        this.menuCorrida(corridaAtual, usuario);
    }

    public void menuCorrida(Corrida corridaAtual, Usuario usuario) {

        while (true) {
            System.out.println("==============================================\n");
            System.out.println("    [1] - Visualizar informacoes ");
            System.out.println("    [2] - Sair");
            System.out.println("==============================================");
            System.out.print  (" Opção: "); int opcaoEscolhida = Integer.parseInt(scan.nextLine());
            switch (opcaoEscolhida) {
                case 1 -> this.visualizarInformacoesCorridaAtual(corridaAtual, usuario);
                case 2 -> {return;}
            }
        }
    }

    public void visualizarInformacoesCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        CarroController carroController = new CarroController();

        System.out.println("==============================================");
        System.out.println("Criador: " + usuario.getIdUsuario());
        System.out.println("Horario: " + corridaAtual.getHora());
        System.out.println("Data: " + corridaAtual.getDia() + "/" + corridaAtual.getMes() + "/" + corridaAtual.getAno());
        System.out.println("Carro: " + carroController.retornarCarro(usuario.getIdUsuario()));
        System.out.println("Preço: R$" + corridaAtual.getPreco());

    }

}
