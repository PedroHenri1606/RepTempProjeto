package model;

public class Carro {
    private long id;
    private CarroNome nome;
    private CarroFabricante fabricante;
    private CarroCor cor;
    private long ano;
    private String placa;

    public Carro() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarroNome getNome() {
        return nome;
    }

    public void setNome(CarroNome nome) {
        this.nome = nome;
    }

    public CarroFabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(CarroFabricante fabricante) {
        this.fabricante = fabricante;
    }

    public CarroCor getCor() {
        return cor;
    }

    public void setCor(CarroCor cor) {
        this.cor = cor;
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return fabricante + " " + nome + " " + cor + "\n" + "Placa: "+ placa;
    }
}
