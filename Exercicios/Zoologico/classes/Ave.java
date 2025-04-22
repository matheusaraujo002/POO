package classes;

public class Ave extends AnimalBase {
    private String corDasPenas;

    public Ave(String nome, Habitat habitat, int idade, String corDasPenas) {
        super(nome, habitat, idade);
        this.corDasPenas = corDasPenas;
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se movendo.");
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " emitindo som de uma ave.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Ave: " + nome + ", Idade: " + getIdade() + ", Habitat: " + habitat + ", Cor das penas: " + corDasPenas);
    }
}
