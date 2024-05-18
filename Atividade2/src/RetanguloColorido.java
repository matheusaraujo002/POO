public class RetanguloColorido extends Retangulo {

    public RetanguloColorido(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public void desenhar() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        System.out.print(ANSI_RED + "+");
        for (int i = 0; i < largura; i++) {
            System.out.print("-");
        }
        System.out.println("+" + ANSI_RESET);

        for (int i = 0; i < altura; i++) {
            System.out.print(ANSI_RED + "|");
            for (int j = 0; j < largura; j++) {
                System.out.print(" ");
            }
            System.out.println("|" + ANSI_RESET);
        }

        System.out.print(ANSI_RED + "+");
        for (int i = 0; i < largura; i++) {
            System.out.print("-");
        }
        System.out.println("+" + ANSI_RESET);
    }
}
