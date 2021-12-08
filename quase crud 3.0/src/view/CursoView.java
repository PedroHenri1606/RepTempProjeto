package view;

import controller.CursoController;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    CursoController cursoController = new CursoController();

    public void cadastrarCurso() {

        Curso curso = new Curso();
        Scanner scan = new Scanner(System.in);

        System.out.print  (" Nome do curso: "); curso.setNome(scan.nextLine());
        System.out.println("==============================================\n");
        this.cursoController.adicionar(curso);
    }

    public String escolherCurso(int id) {
        return cursoController.escolherCurso(id);
    }

    public List<Curso> listar() {
        List<Curso> cursos = cursoController.listar();
        for (Curso curso : cursos) {
            System.out.println("|Id: " + curso.getId() + " | Curso: " + curso.getNome());
        }
        return cursos;
    }
}