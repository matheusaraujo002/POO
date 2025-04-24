package estruturas;

public class Fila {

    private Object[] elementos;
    private int inicio, fim, tamanho, capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public void enfileirar(Object valor) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }

        elementos[fim] = valor;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }

    public Object desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        Object valor = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void mostrarFila() {
        System.out.println("Fila de Impressão:");
        if (tamanho != 0) {
            for (int i = 0; i < tamanho; i++) {
                int index = (inicio + i) % capacidade;
                System.out.println(elementos[index]);
            }
        } else {
            System.out.println("Fila Vazia!");
        }
    }
}
