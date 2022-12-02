public class Administrador extends Funcionario {

    static final double bonus = 0.06;

    public Administrador(String nome, double valorHora, double totalHoras) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
        this.funcao = "administrador";
    }

    @Override
    public double verValorAReceber() {
        double base = this.valorHora * this.totalHoras;
        return base + (base * Administrador.bonus);
    }

}
