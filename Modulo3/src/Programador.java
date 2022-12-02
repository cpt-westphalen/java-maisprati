/**
 * Programador
 */
public class Programador extends Funcionario {

    static final double bonus = 0.05;

    public Programador(String nome, double valorHora, double totalHoras) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
        this.funcao = "programador";
    }

    @Override
    public double verValorAReceber() {
        double base = this.valorHora * this.totalHoras;
        return base + (base * Programador.bonus);
    }

}