package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void setupTables() {
        try (Connection con = ConexaoDB.getInstancia().getConnection(); Statement stmt = con.createStatement()) {

            // Criação da tabela autor
            String createAutorTable = """
                CREATE TABLE IF NOT EXISTS autor (
                    id_autor INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    nacionalidade TEXT
                );
                """;
            stmt.execute(createAutorTable);

            // Criação da tabela livro
            String createLivroTable = """
                CREATE TABLE IF NOT EXISTS livro (
                    id_livro INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    ano_publicacao INTEGER,
                    id_autor INTEGER,
                    FOREIGN KEY (id_autor) REFERENCES autor(id_autor)
                );
                """;
            stmt.execute(createLivroTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
