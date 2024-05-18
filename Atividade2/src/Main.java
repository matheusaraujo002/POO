public class Main {
    public static void main(String[] args) {
        Retangulo[] retangulos = {
                new RetanguloBordaArredondada(20, 3),
                new RetanguloLinhaDupla(20, 3),
                new RetanguloAsciiArt(20, 3),
                new RetanguloColorido(20, 3)
        };

        for (Retangulo retangulo : retangulos) {
            retangulo.desenhar();
            System.out.println();
        }
    }
}
