public abstract class Retangulo {
    protected int largura;
    protected int altura;

    public Retangulo(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public abstract void desenhar();
}
