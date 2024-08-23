import dao.AutorDAO;
import dao.LivroDAO;
import dao.SetupDatabase;
import entity.Autor;
import entity.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SetupDatabase.setupTables();

        AutorDAO autorDAO = new AutorDAO();
        LivroDAO livroDAO = new LivroDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Inserir Autor");
            System.out.println("2. Inserir Livro");
            System.out.println("3. Atualizar Autor");
            System.out.println("4. Atualizar Livro");
            System.out.println("5. Excluir Autor");
            System.out.println("6. Excluir Livro");
            System.out.println("7. Listar Todos os Autores");
            System.out.println("8. Listar Todos os Livros");
            System.out.println("9. Listar Livros por Autor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Inserir Autor
                    Autor novoAutor = new Autor();
                    System.out.print("Nome do autor: ");
                    novoAutor.setNome(scanner.nextLine());
                    System.out.print("Nacionalidade: ");
                    novoAutor.setNacionalidade(scanner.nextLine());
                    autorDAO.inserir(novoAutor);
                    System.out.println("Autor inserido com sucesso!");
                    break;

                case 2:
                    // Inserir Livro
                    Livro novoLivro = new Livro();
                    System.out.print("Título do livro: ");
                    novoLivro.setTitulo(scanner.nextLine());
                    System.out.print("Ano de publicação: ");
                    novoLivro.setAnoPublicacao(scanner.nextInt());
                    System.out.print("ID do autor: ");
                    novoLivro.setIdAutor(scanner.nextInt());
                    livroDAO.inserir(novoLivro);
                    System.out.println("Livro inserido com sucesso!");
                    break;

                case 3:
                    // Atualizar Autor
                    Autor autorAtualizado = new Autor();
                    System.out.print("ID do autor a atualizar: ");
                    autorAtualizado.setId(scanner.nextInt());
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Novo nome do autor: ");
                    autorAtualizado.setNome(scanner.nextLine());
                    System.out.print("Nova nacionalidade: ");
                    autorAtualizado.setNacionalidade(scanner.nextLine());
                    autorDAO.atualizar(autorAtualizado);
                    System.out.println("Autor atualizado com sucesso!");
                    break;

                case 4:
                    // Atualizar Livro
                    Livro livroAtualizado = new Livro();
                    System.out.print("ID do livro a atualizar: ");
                    livroAtualizado.setId(scanner.nextInt());
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Novo título do livro: ");
                    livroAtualizado.setTitulo(scanner.nextLine());
                    System.out.print("Novo ano de publicação: ");
                    livroAtualizado.setAnoPublicacao(scanner.nextInt());
                    System.out.print("ID do autor: ");
                    livroAtualizado.setIdAutor(scanner.nextInt());
                    livroDAO.atualizar(livroAtualizado);
                    System.out.println("Livro atualizado com sucesso!");
                    break;

                case 5:
                    // Excluir Autor
                    System.out.print("ID do autor a excluir: ");
                    int idAutorExcluir = scanner.nextInt();
                    autorDAO.deletar(idAutorExcluir);
                    System.out.println("Autor excluído com sucesso!");
                    break;

                case 6:
                    // Excluir Livro
                    System.out.print("ID do livro a excluir: ");
                    int idLivroExcluir = scanner.nextInt();
                    livroDAO.deletar(idLivroExcluir);
                    System.out.println("Livro excluído com sucesso!");
                    break;

                case 7:
                    // Listar Todos os Autores
                    List<Autor> autores = autorDAO.listar();
                    System.out.println("\n--- Lista de Autores ---");
                    autores.forEach(System.out::println);
                    break;

                case 8:
                    // Listar Todos os Livros
                    List<Livro> livros = livroDAO.listar();
                    System.out.println("\n--- Lista de Livros ---");
                    livros.forEach(System.out::println);
                    break;

                case 9:
                    // Listar Livros por Autor
                    System.out.print("ID do autor para listar os livros: ");
                    int idAutorLivros = scanner.nextInt();
                    List<Livro> livrosPorAutor = livroDAO.listarPorAutor(idAutorLivros);
                    System.out.println("\n--- Livros do Autor ID " + idAutorLivros + " ---");
                    livrosPorAutor.forEach(System.out::println);
                    break;

                case 0:
                    running = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
