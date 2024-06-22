import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Adicionando alguns quartos ao hotel
        hotel.adicionarQuarto(new Quarto(101, "Simples"));
        hotel.adicionarQuarto(new Quarto(102, "Simples"));
        hotel.adicionarQuarto(new Quarto(201, "Duplo"));
        hotel.adicionarQuarto(new Quarto(202, "Duplo"));
        hotel.adicionarQuarto(new Quarto(301, "Suite"));
        hotel.adicionarQuarto(new Quarto(302, "Suite"));

        boolean executando = true;
        System.out.println("____________________________________________________");
        System.out.println("Bem-Vindo ao Sistema de Reserva de Hotel!");

        while (executando) {
            System.out.println("\nEscolha uma opção do Sistema de Reserva:");
            System.out.println("1. Listar todos os quartos");
            System.out.println("2. Filtrar quartos disponíveis");
            System.out.println("3. Reservar quarto");
            System.out.println("4. Sair");
            System.out.print("\nDigite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    hotel.listarQuartos();
                    break;
                case 2:
                    System.out.println("____________________________________________________");
                    System.out.print("Informe o tipo de quarto (Simples, Duplo, Suite): ");
                    String tipo = scanner.next();
                    System.out.println("____________________________________________________");
                    List<Quarto> disponiveis = hotel.buscarQuartosDisponiveis(tipo);
                    if (disponiveis.isEmpty()) {
                        System.out.println("⚠ Nenhum quarto disponível do tipo: " + tipo);
                        System.out.println("____________________________________________________");
                    } else {
                        System.out.println("Quartos disponíveis do tipo " + tipo + ":");
                        for (Quarto quarto : disponiveis) {
                            System.out.println(quarto);
                        }
                        System.out.println("____________________________________________________");
                    }
                    break;
                case 3:
                    System.out.println("____________________________________________________");
                    System.out.print("Informe o número do quarto a ser reservado: ");
                    int numero = scanner.nextInt();
                    hotel.reservarQuarto(numero);
                    System.out.println("____________________________________________________");
                    break;
                case 4:
                    executando = false;
                    System.out.println("____________________________________________________");
                    System.out.println("🛑 Sistema fechado com sucesso! Até mais.");
                    System.out.println("____________________________________________________");
                    break;
                default:
                    System.out.println("____________________________________________________");
                    System.out.println("⚠ Opção inválida! Digite algum número válido de opção.");
                    System.out.println("____________________________________________________");
            }
        }

        scanner.close();
    }
}