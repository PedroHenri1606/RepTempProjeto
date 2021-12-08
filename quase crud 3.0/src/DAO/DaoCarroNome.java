package DAO;

import fabrica.Factory;
import model.CarroNome;
import view.CarroNomeView;
import view.CarroView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarroNome {

    Connection connection = null;
    CarroNome carroNome = new CarroNome();

    public DaoCarroNome(){
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCarroNome(){

        String sql = "CREATE TABLE IF NOT EXISTS carroNome("+
                     "id_nomeCarro bigint primary key auto_increment,"+
                     "nome VARCHAR(45))";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CarroNome adicionar (CarroNome carroNome){

        String sql = "INSERT INTO uniflow.carroNome (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carroNome.getNome());
            statement.execute();
            statement.close();
            return carroNome;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CarroNome> listar() {

        String sql = "SELECT * FROM uniflow.carronome";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList nomes = new ArrayList();

            while (resultSet.next()) {
                CarroNome carroNome = new CarroNome();
                carroNome.setId(resultSet.getLong("id_nomeCarro"));
                carroNome.setNome(resultSet.getString("nome"));
                nomes.add(carroNome);
            }
            return nomes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarroNome retornarNome(long id) {

        String sql = "SELECT nome_carro from carro where id_carro = " + id;

        List<CarroNome> modelos = new ArrayList<>();
        CarroNome carroNome = new CarroNome();
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carroNome.setNome(resultSet.getString("nome_carro"));
            }
            statement.execute();
            statement.close();

            return carroNome;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
