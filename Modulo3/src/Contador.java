public class Contador extends Funcionario {

    static final double bonus = 0.03;

    public Contador(String nome, double valorHora, double totalHoras) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
        this.funcao = "contador";
    }

    @Override
    public double verValorAReceber() {
        double base = this.valorHora * this.totalHoras;
        return base + (base * Contador.bonus);
    }

}
