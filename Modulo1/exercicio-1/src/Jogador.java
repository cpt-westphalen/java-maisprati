import java.util.InputMismatchException;

public class Jogador {

    private String nome;
    private int gols;
    private int assistencias;

    public Jogador(String nome) {
        this.nome = nome;
        this.gols = 0;
        this.assistencias = 0;
    }

    public String nome() {
        return this.nome;
    }

    public int gols() {
        return this.gols;
    }

    public int gols(int quantidade) throws InputMismatchException {
        if (quantidade > 0) {
            this.gols += quantidade;
            return this.gols;
        } else {
            throw new InputMismatchException("Insira um número inteiro positivo para adicionar novo gol.");
        }
    }

    public int assistencias() {
        return this.assistencias;
    }

    public int assistencias(int quantidade) throws InputMismatchException {
        if (quantidade > 0) {
            this.assistencias += quantidade;
            return this.assistencias;
        } else {
            throw new InputMismatchException("Insira um número inteiro positivo para adicionar nova assistência.");
        }
    }

    // public int adicionarGol(int n) {
    // if (n > 0) {
    // this.gols += n;
    // return this.gols;
    // } else {
    // return this.gols;
    // }
    // }

    // public int adicionarAssistencia(int n) {
    // if (n > 0) {
    // this.assistencias += n;
    // return this.assistencias;
    // } else {
    // return this.assistencias;
    // }
    // }

}
