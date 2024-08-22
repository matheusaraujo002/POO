package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static ConexaoDB instancia;
    private ConexaoDB(){}

    public synchronized static ConexaoDB getInstancia(){
        if(instancia == null){
            instancia = new ConexaoDB();
        }
        return instancia;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:livraria.db";
        return DriverManager.getConnection(url);
    }
}
