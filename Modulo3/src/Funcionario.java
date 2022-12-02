/**
 * Funcionario
 */
abstract class Funcionario {
    String nome;
    double valorHora;
    double totalHoras;
    String funcao;

    public abstract double verValorAReceber();

    public String toString() {
        return this.nome + ", " + this.funcao + ": (v/h: " + this.valorHora + ", total horas: " + this.totalHoras
                + ", valor a receber: " + this.verValorAReceber() + ")";
    }
}