public class RetanguloAsciiArt extends Retangulo {

    public RetanguloAsciiArt(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public void desenhar() {
        System.out.print("+");
        for (int i = 0; i < largura; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < altura; i++) {
            System.out.print("|");
            for (int j = 0; j < largura; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < largura; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
