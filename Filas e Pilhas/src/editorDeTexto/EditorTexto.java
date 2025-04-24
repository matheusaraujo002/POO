package editorDeTexto;

import estruturas.Pilha;

public class EditorTexto {

    private String textoAtual = "";
    private Pilha pilhaDesfazer;
    private Pilha pilhaRefazer;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha(capacidade);
        pilhaRefazer = new Pilha(capacidade);
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual);
        pilhaRefazer.limpar();
        textoAtual += novoTexto;
        mostrarTexto();
    }

    public void desfazer() {
        String anterior = pilhaDesfazer.desempilhar();
        if (anterior != null) {
            pilhaRefazer.empilhar(textoAtual);
            textoAtual = anterior;
        } else {
            System.out.println("Nada a desfazer");
        }
        mostrarTexto();
    }

    public void refazer() {
        String futuro = pilhaRefazer.desempilhar();
        if (futuro != null) {
            pilhaDesfazer.empilhar(textoAtual);
            textoAtual = futuro;
        } else {
            System.out.println("Nada a refazer");
        }
        mostrarTexto();
    }

    public void mostrarTexto() {
        System.out.println("Texto atual: " + textoAtual);
    }
}
