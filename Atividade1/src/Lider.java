class Lider extends Funcionario {
    public Lider(String nome, double valorHora, int horasTrabalhadas) {
        super(nome, valorHora, horasTrabalhadas);
    }

    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        return salarioBase * 1.02; // Incrementa em 2%
    }
}