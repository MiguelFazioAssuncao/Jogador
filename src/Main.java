import modules.Jogador;
import modules.Jogo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        Jogo jogo = new Jogo();

        ArrayList<Jogador> jogadores = inicializarJogadores(scan);

        while (continuar) {
            System.out.println("Escolha uma das opções:\n" +
                    "1 - Iniciar partida\n" +
                    "2 - Ver ranking completo\n" +
                    "3 - Ver top 10\n" +
                    "4 - Encerrar o jogo");

            int opcao = scan.nextInt();
            scan.nextLine();

            System.out.println("Opção escolhida: " + opcao);

            switch (opcao) {
                case 1:
                    Jogador jogador = selecionarOuCriarJogador(scan, jogadores);
                    if (jogador != null) {
                        jogo.jogar(jogador, scan);

                        boolean continuarJogo = true;
                        while (continuarJogo) {
                            System.out.println("Qual das seguintes opções você deseja seguir:");
                            System.out.println("1 - Ver ranking completo");
                            System.out.println("2 - Ver top 10");
                            System.out.println("3 - Jogar novamente");
                            System.out.println("4 - Jogar outro jogo");
                            System.out.println("5 - Encerrar o Jogo");

                            int opcaoFinal = scan.nextInt();
                            scan.nextLine();

                            System.out.println("Opção escolhida: " + opcaoFinal);

                            switch (opcaoFinal) {
                                case 1:
                                    System.out.println("Exibindo resultados completos...");
                                    jogo.exibirRankingCompleto(jogadores);
                                    break;
                                case 2:
                                    System.out.println("Exibindo os top 10 jogadores...");
                                    jogo.exibirTop10(jogadores);
                                    break;
                                case 3:
                                    System.out.println("Jogando novamente...");
                                    jogo.jogar(jogador, scan);
                                    break;
                                case 4:
                                    System.out.println("Bem-vindo ao jogo Chutando Alto!");
                                    int num = solicitarValorMaximo(scan);
                                    jogo.jogar(num, jogador, scan);
                                    break;
                                case 5:
                                    System.out.println("Saindo...");
                                    continuarJogo = false;
                                    continuar = false;
                                    scan.close();
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Exibindo resultados completos...");
                    jogo.exibirRankingCompleto(jogadores);
                    break;
                case 3:
                    System.out.println("Exibindo os top 10 jogadores...");
                    jogo.exibirTop10(jogadores);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    continuar = false;
                    scan.close();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static ArrayList<Jogador> inicializarJogadores(Scanner scan) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        Set<String> nomesExistentes = new HashSet<>();

        System.out.println("Adicione os jogadores!");

        for (int i = 0; i < 10; i++) {
            String nome;

            do {
                System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
                nome = scan.nextLine();

                if (nomesExistentes.contains(nome)) {
                    System.out.println("Nome já adicionado. Escolha outro nome!");
                } else {
                    nomesExistentes.add(nome);
                    break;
                }
            } while (true);

            Jogador jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setPontuacao(0);
            jogadores.add(jogador);
        }

        return jogadores;
    }

    private static Jogador selecionarOuCriarJogador(Scanner scan, ArrayList<Jogador> jogadores) {
        System.out.println("Escolha uma das opções abaixo:\n" +
                "1 - Jogador existente\n" +
                "2 - Adicionar novo jogador");
        int opcao = scan.nextInt();
        scan.nextLine();

        Jogador jogador = null;
        if (opcao == 1) {
            System.out.print("Digite o nome do jogador: ");
            String nome = scan.nextLine();
            for (Jogador j : jogadores) {
                if (j.getNome().equals(nome)) {
                    jogador = j;
                    break;
                }
            }
            if (jogador == null) {
                System.out.println("Jogador não encontrado.");
                return null;
            }
        } else if (opcao == 2) {
            System.out.print("Digite o nome do novo jogador: ");
            String nome = scan.nextLine();
            jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setPontuacao(0);
            jogadores.add(jogador);
        } else {
            System.out.println("Opção inválida.");
            return null;
        }

        return jogador;
    }

    private static int solicitarValorMaximo(Scanner scan) {
        int num;
        while (true) {
            System.out.println("Digite o valor máximo para o jogo:");
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0) {
                    break;
                } else {
                    System.out.println("Digite um número maior que zero!");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scan.nextLine();
            }
        }
        return num;
    }
}
