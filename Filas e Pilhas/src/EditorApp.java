import editorDeTexto.EditorTexto;

public class EditorApp {

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto(3);

        editor.inserirTexto("Oceano");
        editor.inserirTexto(" Atlântico");
        editor.inserirTexto(" Da Silveira");
        editor.desfazer();
        editor.refazer();
        editor.inserirTexto(" de Souza");
        editor.desfazer();
        editor.desfazer();
        editor.desfazer();
    }
}

