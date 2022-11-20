import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {

        System.out.println("Iniciando app.");

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>(5);

        try {
            if (jogadores.isEmpty()) {
                System.out.println("Sem jogadores no sistema...");
                Jogador jogador = criaJogador(sc);
                jogadores.add(jogador);
            }
            boolean loopGeral = true;
            do {
                System.out.println(
                        "Escolher jogador existente ou criar novo jogador? (\"escolher\" / \"criar\" / \"sair\")");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("escolher")) {
                    escolherJogador(sc, jogadores);
                } else if (input.equalsIgnoreCase("criar")) {
                    Jogador jogador = criaJogador(sc);
                    jogadores.add(jogador);
                } else if (input.equalsIgnoreCase("sair")) {
                    loopGeral = false;
                } else {
                    System.out.println("Não entendi. Confira o que foi digitado.");
                }
            } while (loopGeral);

        } catch (Exception e) {
            System.out.println("Você conseguiu criar um erro. Parabéns.");
        }
        System.out.println("Encerrando aplicação...");
        sc.close();
    }

    private static Jogador criaJogador(Scanner sc) {
        System.out.println("Digite um nome para o jogador:");
        String input = sc.nextLine().trim();
        Jogador jogador = new Jogador(input);
        System.out.println("Novo jogador adicionado! Seja bem-vindo, " + jogador.nome());
        return jogador;
    }

    private static void escolherJogador(Scanner sc, ArrayList<Jogador> jogadores) {
        String[] nomes = new String[jogadores.size()];
        for (int i = 0; i < jogadores.size(); i++) {
            nomes[i] = jogadores.get(i).nome();
        }

        boolean loopEscolherJogador = true;
        do {

            System.out
                    .println("Os jogadores atuais são: " + String.join(", ", nomes) + ". Digite um nome.");
            input = sc.nextLine();
            int index = -1;
            for (int i = 0; i < jogadores.size(); i++) {
                if (jogadores.get(i).nome().equalsIgnoreCase(input)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Não foi possível encontrar o nome digitado. Revise.");
            } else {
                verOuInserirDadosJogador(sc, jogadores.get(index));
                loopEscolherJogador = false;
            }
        } while (loopEscolherJogador);
    }

    private static void verOuInserirDadosJogador(Scanner sc, Jogador player) {
        boolean loopGetOrSet = true;
        do {

            System.out.println("Deseja \"ver\" ou \"inserir\" dados para " + player.nome() + "? (\"x\" para voltar)");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("ver")) {
                verDados(sc, player);
            } else if (input.equalsIgnoreCase("inserir")) {
                inserirDados(sc, player);
            } else if (input.equalsIgnoreCase("x")) {
                loopGetOrSet = false;
            } else {
                System.out.println("Ops, não entendi. Confira o que você digitou.");
            }
        } while (loopGetOrSet);
    }

    private static void verDados(Scanner sc, Jogador player) {
        boolean loopVerDados = true;
        do {
            System.out.println(
                    "Gostaria de ver \"gols\" ou \"assistências\" de " + player.nome() + "? (\"x\" para voltar)");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("gol") || input.equalsIgnoreCase("gols")) {
                System.out.println(player.nome() + " fez " + player.gols() + " gols até agora.");
            } else if (input.equalsIgnoreCase("assistências") || input.equalsIgnoreCase("assistencias")) {
                System.out.println(player.nome() + " fez " + player.assistencias() + " assistências até agora.");
            } else if (input.equalsIgnoreCase("x")) {
                loopVerDados = false;
            } else {
                System.out.println("Desculpe, não entendi. Digite apenas \"gols\" ou \"assistências\"");
            }
        } while (loopVerDados);
    }

    private static void inserirDados(Scanner sc, Jogador player) {
        System.out.println(
                "Adicione novos registros para " + player.nome() + ". Digite \"gol\" ou \"assistência\".");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("gol") || input.equalsIgnoreCase("gols")) {
            inserirGols(sc, player);
        } else if (input.equalsIgnoreCase("assistência") || input.equalsIgnoreCase("assistencia")) {
            inserirAssistencia(sc, player);
        } else {
            System.out.println("Ops, não entendi. Confira o que foi digitado.");
        }
    }

    private static void inserirGols(Scanner sc, Jogador player) {
        boolean loopGols = true;
        do {
            System.out.println("Digite quantos gols deseja registrar: (ou \"x\" para voltar)");
            input = sc.nextLine();
            if (!input.equalsIgnoreCase("x")) {
                try {
                    int inputNumber = Integer.parseInt(input);
                    player.gols(inputNumber);
                    System.out.println("Feito! " + inputNumber + " gols foram adicionados para "
                            + player.nome());
                    loopGols = false;
                } catch (Exception e) {
                    if (e instanceof NumberFormatException) {
                        System.out.println("Desculpe, não entendi.");
                    } else {
                        System.out.println("O número digitado deve ser inteiro e maior que zero.");
                    }
                }
            } else {
                loopGols = false;
            }
        } while (loopGols);
    }

    private static void inserirAssistencia(Scanner sc, Jogador player) {
        boolean loopAssistencia = true;
        do {
            System.out.println("Digite quantas assistências deseja registrar: (ou \"x\" para voltar)");
            input = sc.nextLine();
            if (!input.equalsIgnoreCase("x")) {
                try {
                    int inputNumber = Integer.parseInt(input);
                    player.assistencias(inputNumber);
                    System.out.println("Feito! " + inputNumber + " assistências foram adicionadas para "
                            + player.nome());
                    loopAssistencia = false;
                } catch (Exception e) {
                    System.out.println("Desculpe, não entendi.");
                    System.out.println("O número digitado deve ser inteiro e maior que zero.");
                }
            } else {
                loopAssistencia = false;
            }
        } while (loopAssistencia);
    }

}
