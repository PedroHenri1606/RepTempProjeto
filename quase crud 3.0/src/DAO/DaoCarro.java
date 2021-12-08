package DAO;

import fabrica.Factory;
import model.Carro;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarro {

    Connection connection = null;

    public DaoCarro() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCarro() {
        String sql = "CREATE TABLE IF NOT EXISTS carro(" +
                "id_carro bigint primary key auto_increment," +
                "nome_carro VARCHAR(45)," +
                "foreign key(nome) references carronome(nome),"+
                "nome_fabricante VARCHAR(45)," +
                "foreign key(nome) references carrofabricante(nome),"+
                "nome_cor VARCHAR(45)," +
                "foreign key(nome) references carrocor(nome),"+
                "ano_carro bigint," +
                "placa_carro VARCHAR(45))";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Carro adicionar(Carro carro) {

        String sql = "INSERT INTO uniflow.carro (nome_carro,nome_fabricante,nome_cor,ano_carro,placa_carro) value (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carro.getNome().getNome());
            statement.setString(2, carro.getFabricante().getNome());
            statement.setString(3, carro.getCor().getNome());
            statement.setLong(4, carro.getAno());
            statement.setString(5, carro.getPlaca());
            statement.execute();
            statement.close();
            return carro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
/*
    public List<Carro> listar() {

        String sql = "SELECT * FROM uniflow.carro";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList carros = new ArrayList();

            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getLong("id_carro"));
                carro.setNome(resultSet.getString("nome_carro"));
                carro.setFabricante(resultSet.getString("nome_fabricante"));
                carro.setCor(resultSet.getString("nome_cor"));
                carro.setAno(resultSet.getLong("ano_carro"));
                carro.setPlaca(resultSet.getString("placa_carro"));
                carros.add(carro);
            }
            return carros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
    public Carro retornarDados(long id) {

        String sql = "SELECT id_carro from carro where id_carro = " + id;

        List<Carro> carros = new ArrayList<>();
        Carro carro = new Carro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carro.setId(resultSet.getLong("id_carro"));
                carros.add(carro);
            }
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    public Carro retornarCarro(long id) {

        String sql = "SELECT nome_fabricante,nome_carro,nome_cor,placa_carro from carro where id_carro = " + id;

        List<Carro> carros = new ArrayList<>();
        Carro carro = new Carro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
             //   carro.setFabricante(resultSet.getString("nome_fabricante"));
             //   carro.setNome(resultSet.getString("nome_carro"));
             //   carro.setCor(resultSet.getString("nome_cor"));
                carro.setPlaca(resultSet.getString("placa_carro"));
                carros.add(carro);
            }
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    public String retornarNome(long id) {

        String sql = "SELECT nome_carro from carro where id_carro = " + id;

        String tmp1 = "";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tmp1 = resultSet.getString("nome_carro");
            }
            statement.execute();
            statement.close();

            return tmp1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
