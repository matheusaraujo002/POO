import classes.Ave;
import classes.Habitat;
import classes.Mamifero;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------");
        Mamifero leao = new Mamifero("Leão", Habitat.TERRESTRE, 5, "Amarela");
        leao.emitirSom();
        leao.mover();
        leao.exibirDetalhes();

        System.out.println("--------------------------------------------------------------");

        Ave passaro = new Ave("Coruja", Habitat.AEREO, 2, "Branca");
        passaro.emitirSom();
        passaro.mover();
        passaro.exibirDetalhes();
        System.out.println("--------------------------------------------------------------");
    }
}