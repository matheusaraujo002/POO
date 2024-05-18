public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Carlos", 50, 160);
        Lider l1 = new Lider("Ana", 60, 160);
        Gerente g1 = new Gerente("Marcos", 80, 160);

        System.out.println(f1.getNome() + " - Salário: " + f1.calcularSalario());
        System.out.println(l1.getNome() + " - Salário: " + l1.calcularSalario());
        System.out.println(g1.getNome() + " - Salário: " + g1.calcularSalario());
    }
}