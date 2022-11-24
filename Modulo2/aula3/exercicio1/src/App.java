import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * App
 */
public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String nome;
        int matricula;
        int nota;

        System.out.println("Olá! Para registrar as notas, insira o nome do ou da estudante: ");
        nome = sc.nextLine();

        System.out.println("Insira o número de matrícula: ");
        matricula = readPositiveIntFromInputLoop("A matrícula precisa ser um número inteiro positivo.");

        Aluno aluno = new Aluno(nome, matricula);

        System.out
                .println("Estudante " + aluno.nome + ", de matrícula nº " + aluno.matricula + " teve registro criado.");

        boolean loop = true;
        String[] textos = { "Digite a primeira nota: ", "Digite a segunda nota: ", "Digite a terceira nota: " };
        while (loop) {
            try {
                int index = aluno.lastNotaIndex();
                if (index == 3)
                    break;
                System.out.println(textos[index]);
                nota = readPositiveIntFromInputLoop("A nota precisa ser um número inteiro positivo.");
                aluno.setNota(nota);
            } catch (Exception e) {
                System.out.println("As notas não podem passar de 100");
            }
        }

        System.out.println(aluno.getNotas());

        sc.close();
    }

    private static int readPositiveIntFromInputLoop(String errorMessage) {
        boolean isPositiveNumber = false;
        String input;
        int number = 0;

        do {
            try {
                input = sc.nextLine();
                number = Integer.parseInt(input);
                if (number >= 0) {
                    isPositiveNumber = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        } while (!isPositiveNumber);

        return number;
    }
}