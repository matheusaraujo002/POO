import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;

    public Hotel() {
        quartos = new ArrayList<>();
    }

    public void listarQuartos() {
        System.out.println("____________________________________________________");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
        System.out.println("____________________________________________________");
    }

    public List<Quarto> buscarQuartosDisponiveis(String tipo) {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel() && quarto.getTipo().equalsIgnoreCase(tipo)) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    public void reservarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero && quarto.isDisponivel()) {
                quarto.reservar();
                System.out.println("✅ Quarto " + numero + " reservado com sucesso.");
                return;
            }
        }
        System.out.println("⚠ Este quarto não está disponível para reserva.");
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }
}