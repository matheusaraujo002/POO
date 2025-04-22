package classes;

public class Mamifero extends AnimalBase {
    private String pelagem;

    public Mamifero(String nome, Habitat habitat, int idade, String pelagem) {
        super(nome, habitat, idade);
        this.pelagem = pelagem;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " emitindo som de um mamífero.");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se movendo.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Mamífero: " + nome + ", Idade: " + getIdade() + ", Habitat: " + habitat + ", Pelagem: " + pelagem);
    }
}