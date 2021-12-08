package DAO;

import fabrica.Factory;
import model.Carro;
import model.CarroFabricante;
import model.CarroNome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarroFabricante {

    Connection connection = null;
    CarroFabricante carroFabricante = new CarroFabricante();

    public DaoCarroFabricante(){ this.connection = new Factory().getConection();}

    public void criarTabelaCarroFabricante(){

        String sql = "CREATE TABLE IF NOT EXISTS carroFabricante("+
                "id_fabricante bigint primary key auto_increment,"+
                "nome VARCHAR(45))";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CarroFabricante adicionar (CarroFabricante carroFabricante){

        String sql = "INSERT INTO uniflow.carroFabricante (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carroFabricante.getNome());
            statement.execute();
            statement.close();
            return carroFabricante;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CarroFabricante> listar() {

        String sql = "SELECT * FROM uniflow.carrofabricante";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList fabricantes = new ArrayList();

            while (resultSet.next()) {
                CarroFabricante carroFabricante = new CarroFabricante();
                carroFabricante.setId(resultSet.getLong("id_fabricante"));
                carroFabricante.setNome(resultSet.getString("nome"));
                fabricantes.add(carroFabricante);
            }
            return fabricantes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarroFabricante retornarNome(long id) {

        String sql = "SELECT nome from carroFabricante where id_fabricante = " + id;

        List<CarroFabricante> fabricantes = new ArrayList<>();
        CarroFabricante carroFabricante = new CarroFabricante();

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carroFabricante.setNome(resultSet.getString("nome"));
            }
            statement.execute();
            statement.close();

            return carroFabricante;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
