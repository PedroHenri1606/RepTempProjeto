package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    String senha = "PEDROHENRIQUE123";
    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/uniflow", "root", senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
