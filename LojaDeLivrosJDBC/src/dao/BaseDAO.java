package dao;

import java.sql.Connection;
import java.sql.SQLException;

class BaseDAO {
    protected Connection con() throws SQLException {
        return ConexaoDB.getInstancia().getConnection();
    }
}
