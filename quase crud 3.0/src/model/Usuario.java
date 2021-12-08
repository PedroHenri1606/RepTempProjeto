package model;
public class Usuario {
    long idUsuario;
    String nome;
    String sobrenome;
    String senha;
    String email;
    Bairro bairro;
    Curso curso;
    long sexo;
    long escolha;
    Faculdade destino;
    Carro carro;

    @Override
    public String toString() {
        return nome;

    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public long getEscolha() {
        return escolha;
    }

    public void setEscolha(long escolha) {
        this.escolha = escolha;
    }

    public Faculdade getDestino() {
        return destino;
    }

    public void setDestino(Faculdade destino) {
        this.destino = destino;
    }

    public long getSexo() {
        return sexo;
    }

    public void setSexo(long sexo) {
        this.sexo = sexo;
    }
}
