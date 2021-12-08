package DAO;

import controller.CarroController;
import fabrica.Factory;
import model.Corrida;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoCorrida {
    static List<Corrida> corridas = new ArrayList<>();

    Connection connection;
    CarroController carroController = new CarroController();

    public DaoCorrida() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCorrida() {
        String sql = "CREATE TABLE IF NOT EXISTS corridas(" +
                "id_corrida bigint primary key auto_increment, " +
                "hora VARCHAR(50), " +
                "dia int, mes int, ano int, " +
                "preco decimal(10,2), " +
                "id_usuario bigint, " +
                "foreign key(id_usuario) references usuario(id_usuario),"+
                "id_carro bigint, "+
                "foreign key(id_carro) references carro(id_carro));";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Corrida> visualizar(Usuario usuario) {

        List<Corrida> minhasCorridas = new ArrayList<>();

        String sql = "select * from uniflow.corridas where id_usuario = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, usuario.getIdUsuario());
            ResultSet resultSet = statement.executeQuery();
            Corrida corrida;
            Carro carro;

            while (resultSet.next()) {
                corrida = new Corrida();
                carro = new Carro();

                corrida.setIdCorrida(resultSet.getLong("id_corrida"));
                corrida.setHora(resultSet.getString("hora"));
                corrida.setDia(resultSet.getInt("dia"));
                corrida.setAno(resultSet.getInt("ano"));
                corrida.setMes(resultSet.getInt("mes"));
                corrida.setAno(resultSet.getInt("ano"));
                corrida.setPreco(resultSet.getDouble("preco"));
                corrida.setUser(usuario);
                corrida.setCarro(this.carroController.retornarCarro(resultSet.getLong("id_carro")));
                minhasCorridas.add(corrida);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return minhasCorridas;
    }

    public List<Corrida> visualizarPendentes() {

        List<Corrida> minhasCorridas = new ArrayList<>();
        String sql = "select * from uniflow.corridas";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Corrida corrida;

            while (resultSet.next()) {
                corrida = new Corrida();
                corrida.setIdCorrida(resultSet.getLong("id_corrida"));
                corrida.setHora(resultSet.getString("hora"));
                corrida.setDia(resultSet.getInt("dia"));
                corrida.setAno(resultSet.getInt("ano"));
                corrida.setMes(resultSet.getInt("mes"));
                corrida.setAno(resultSet.getInt("ano"));
                corrida.setPreco(resultSet.getDouble("preco"));
                corrida.setCarro(this.carroController.retornarDados(resultSet.getLong("id_carro")));
                minhasCorridas.add(corrida);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return minhasCorridas;
    }

    public void cadastrarCorrida(Corrida corrida) {
        String sql = "insert into uniflow.corridas(hora, dia, mes, ano, preco, id_usuario, id_carro) value(?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, corrida.getHora());
            statement.setInt(2, corrida.getDia());
            statement.setInt(3, corrida.getMes());
            statement.setInt(4, corrida.getAno());
            statement.setDouble(5, corrida.getPreco());
            statement.setLong(6, corrida.getUser().getIdUsuario());
            statement.setLong(7, corrida.getCarro().getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarAlteracoes(Corrida corrida) {
        String sql = "update uniflow.corridas set hora = ?, dia = ?, mes = ?, ano = ?, preco = ?, id_usuario = ? where id_corrida = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,corrida.getHora());
            statement.setInt(2, corrida.getDia());
            statement.setInt(3, corrida.getMes());
            statement.setInt(4,corrida.getAno());
            statement.setDouble(5,corrida.getPreco());
            statement.setLong(6, corrida.getUser().getIdUsuario());
            statement.setLong(7,corrida.getIdCorrida());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Corrida determinarCorridaAtual(long idCorrida, Usuario usuario) {
        Corrida tmp = new Corrida();
        String sql = "select * from uniflow.corridas where (id_corrida = ? and id_usuario = ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idCorrida);
            statement.setLong(2, usuario.getIdUsuario());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tmp.setIdCorrida(resultSet.getLong("id_corrida"));
                tmp.setHora(resultSet.getString("hora"));
                tmp.setDia(resultSet.getInt("dia"));
                tmp.setAno(resultSet.getInt("ano"));
                tmp.setMes(resultSet.getInt("mes"));
                tmp.setAno(resultSet.getInt("ano"));
                tmp.setPreco(resultSet.getDouble("preco"));
                tmp.setUser(usuario);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }
}