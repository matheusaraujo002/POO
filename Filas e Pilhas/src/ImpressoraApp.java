import impressora.FilaImpressao;

public class ImpressoraApp {

    public static void main(String[] args) {
        FilaImpressao fila = new FilaImpressao(5);

        fila.adicionarDocumento("Relatório", 300);
        fila.adicionarDocumento("Currículo", 150);
        fila.adicionarDocumento("Contrato", 400);

        fila.mostrarFila();
        fila.imprimirProximo();
        fila.imprimirProximo();
        fila.mostrarFila();
        fila.imprimirProximo();
        fila.mostrarFila();
    }
}
