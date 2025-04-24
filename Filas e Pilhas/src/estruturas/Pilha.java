package estruturas;

public class Pilha {
    private String[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        this.elementos = new String[capacidade];
        this.topo = -1;
    }

    public void empilhar(String valor) {
        if (topo == elementos.length - 1) {
            System.out.println("Pilha cheia");
            return;
        }
        topo++;
        elementos[topo] = valor;
    }

    public String desempilhar() {
        if (estaVazia()) {
            return null;
        }
        String valor = elementos[topo];
        elementos[topo] = null;
        topo--;
        return valor;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void limpar() {
        for (int i = 0; i <= topo; i++) {
            elementos[i] = null;
        }
        topo = -1;
    }
}
