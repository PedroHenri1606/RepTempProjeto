package model;

public class Faculdade {
    long idFaculdade;
    String nome;

    public Faculdade() {
    }

    @Override
    public String toString() {
        return "|Id: " + idFaculdade  + "| Faculdade: " + nome;
    }

    public long getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(long idFaculdade) {
        this.idFaculdade = idFaculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
