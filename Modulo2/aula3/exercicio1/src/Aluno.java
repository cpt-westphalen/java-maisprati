import java.util.InputMismatchException;

public class Aluno {

    public String nome;
    public int matricula;
    private int[] notas;

    public Aluno(String NOME, int MATRICULA) {
        this.nome = NOME;
        this.matricula = MATRICULA;
        this.notas = new int[] { -1, -1, -1 };
    }

    public String getNotas() {
        return "As notas de " + this.nome + " são: {" + this.notas[0] + ", " + this.notas[1] + ", " + this.notas[2]
                + "}";
    }

    public int lastNotaIndex() {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == -1) {
                return i;
            }
        }
        return notas.length;
    }

    private int getNotaTotal() {
        int soma = 0;
        for (int nota : notas) {
            if (nota != -1) {
                soma += nota;
            }
        }
        return soma;
    }

    public void setNota(int NOVA_NOTA) throws InputMismatchException {
        int soma = getNotaTotal();
        if (soma + NOVA_NOTA > 100)
            throw new InputMismatchException("A soma das notas não pode ser maior que 100.");
        else {
            for (int i = 0; i < 3; i++) {
                if (this.notas[i] == -1) {
                    this.notas[i] = NOVA_NOTA;
                    break;
                }
            }
        }
    }
}
