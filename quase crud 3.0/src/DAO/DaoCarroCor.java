package DAO;

import fabrica.Factory;
import model.CarroCor;
import model.CarroFabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarroCor {

    Connection connection = null;
    CarroCor carroCor = new CarroCor();

    public DaoCarroCor(){ this.connection = new Factory().getConection();}

    public void criarTabelaCarroCor(){
        String sql = "CREATE TABLE IF NOT EXISTS carroCor("+
                "id_cor bigint primary key auto_increment,"+
                "nome VARCHAR(45))";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CarroCor adicionar(CarroCor carroCor){

        String sql = "INSERT INTO uniflow.carroCor (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,carroCor.getNome());
            statement.execute();
            statement.close();
            return carroCor;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CarroCor> listar() {

        String sql = "SELECT * FROM uniflow.carrocor";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList cores = new ArrayList();

            while (resultSet.next()) {
                CarroCor carroCor = new CarroCor();
                carroCor.setId(resultSet.getLong("id_cor"));
                carroCor.setNome(resultSet.getString("nome"));
                cores.add(carroCor);
            }
            return cores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarroCor retornarCor(long id) {

        String sql = "SELECT nome from carroCor where id_cor = " + id;

        List<CarroCor> cores = new ArrayList<>();
        CarroCor carroCor = new CarroCor();

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carroCor.setNome(resultSet.getString("nome"));
            }
            statement.execute();
            statement.close();

            return carroCor;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
