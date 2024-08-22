package dao;

import entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO extends BaseDAO {

    public void inserir(Autor autor) {
        String sql = "INSERT INTO autor (nome, nacionalidade) VALUES (?, ?)";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Autor autor) {
        String sql = "UPDATE autor SET nome = ?, nacionalidade = ? WHERE id_autor = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setInt(3, autor.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM autor WHERE id_autor = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> listar() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM autor ORDER BY nome ASC";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id_autor"));
                autor.setNome(rs.getString("nome"));
                autor.setNacionalidade(rs.getString("nacionalidade"));
                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }

    public Autor obterPorId(int id) {
        String sql = "SELECT * FROM autor WHERE id_autor = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id_autor"));
                    autor.setNome(rs.getString("nome"));
                    autor.setNacionalidade(rs.getString("nacionalidade"));
                    return autor;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
