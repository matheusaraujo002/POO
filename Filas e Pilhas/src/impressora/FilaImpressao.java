package impressora;

import estruturas.Fila;

public class FilaImpressao {

    private Fila fila;

    public FilaImpressao(int capacidade) {
        fila = new Fila(capacidade);
    }

    public void adicionarDocumento(String nome, int tamanho) {
        fila.enfileirar(new Documento(nome, tamanho));
        System.out.println("Documento adicionado: " + nome);
    }

    public void imprimirProximo() {
        Documento doc = (Documento) fila.desenfileirar();
        if (doc != null) {
            System.out.println("Imprimindo: " + doc);
        } else {
            System.out.println("Nenhum documento na fila.");
        }
    }

    public void mostrarFila() {
        fila.mostrarFila();
    }
}
