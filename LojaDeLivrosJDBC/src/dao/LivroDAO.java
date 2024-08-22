package dao;

import entity.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO extends BaseDAO {

    public void inserir(Livro livro) {
        String sql = "INSERT INTO livro (titulo, ano_publicacao, id_autor) VALUES (?, ?, ?)";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setInt(3, livro.getIdAutor());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, ano_publicacao = ?, id_autor = ? WHERE id_livro = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setInt(3, livro.getIdAutor());
            stmt.setInt(4, livro.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM livro WHERE id_livro = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro ORDER BY titulo ASC";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id_livro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                livro.setIdAutor(rs.getInt("id_autor"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public Livro obterPorId(int id) {
        String sql = "SELECT * FROM livro WHERE id_livro = ?";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id_livro"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    livro.setIdAutor(rs.getInt("id_autor"));
                    return livro;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Livro> listarPorAutor(int idAutor) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro WHERE id_autor = ? ORDER BY titulo ASC";
        try (Connection con = con(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id_livro"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    livro.setIdAutor(rs.getInt("id_autor"));
                    livros.add(livro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }
}
