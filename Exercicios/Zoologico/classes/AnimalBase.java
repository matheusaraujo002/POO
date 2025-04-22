package classes;

public abstract class AnimalBase implements Animal {
    protected String nome;
    protected Habitat habitat;
    private int idade;

    public AnimalBase(String nome, Habitat habitat, int idade) {
        this.nome = nome;
        this.habitat = habitat;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public abstract void exibirDetalhes();
}
