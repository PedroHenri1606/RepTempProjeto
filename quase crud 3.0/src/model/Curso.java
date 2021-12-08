package model;

public class Curso {

    private String nome;
    private long id;

    public Curso(String nome, long id) {
        this.nome = nome;
        this.id = id;
    }

    public Curso() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
