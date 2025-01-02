package modules;

import java.util.*;

public class Jogo {
    private Jogador melhorJogador;
    private int numeroJogadas;

    public Jogo() {
        this.melhorJogador = null;
        this.numeroJogadas = 0;
    }

    public void jogar(Jogador jogador, Scanner scan) {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int jogadaDoUsuario = -1;

        System.out.println("Jogador " + jogador.getNome() + ", é sua vez!");

        while (jogadaDoUsuario < 0 || jogadaDoUsuario > 2) {
            System.out.println("Escolha sua jogada: ");
            System.out.println("0 - Pedra");
            System.out.println("1 - Papel");
            System.out.println("2 - Tesoura");

            if (scan.hasNextInt()) {
                jogadaDoUsuario = scan.nextInt();
                scan.nextLine();

                if (jogadaDoUsuario < 0 || jogadaDoUsuario > 2) {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, escolha um número entre 0 e 2.");
                scan.nextLine();
            }
        }

        int jogadaDoSistema = (int) (Math.random() * 3);
        System.out.println("Você escolheu: " + opcoes[jogadaDoUsuario]);
        System.out.println("O sistema escolheu: " + opcoes[jogadaDoSistema]);

        if (jogadaDoSistema == jogadaDoUsuario) {
            System.out.println("Empate!");
        } else if ((jogadaDoSistema == 0 && jogadaDoUsuario == 1) ||
                (jogadaDoSistema == 1 && jogadaDoUsuario == 2) ||
                (jogadaDoSistema == 2 && jogadaDoUsuario == 0)) {
            System.out.println("Você " + jogador.getNome() + " venceu!");
            jogador.setPontuacao(jogador.getPontuacao() + 1);
            atualizarMelhorJogador(jogador);
        } else {
            System.out.println("Você " + jogador.getNome() + " perdeu!");
        }

        numeroJogadas++;
        System.out.println("Pontos atuais de " + jogador.getNome() + ": " + jogador.getPontuacao());
    }

    public void jogar(int num, Jogador jogador, Scanner scan) {
        int numeroEscolhido = -1;

        while (numeroEscolhido < 0 || numeroEscolhido > num) {
            System.out.println("Escolha um número entre 0 e " + num + ":");
            if (scan.hasNextInt()) {
                numeroEscolhido = scan.nextInt();
                if (numeroEscolhido < 0 || numeroEscolhido > num) {
                    System.out.println("Número inválido! Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
                scan.nextLine();
            }
        }

        int numeroAleatorio = (int) (Math.random() * (num + 1));

        if (numeroEscolhido == numeroAleatorio) {
            System.out.println("Parabéns! Você venceu!");
            jogador.setPontuacao(jogador.getPontuacao() + 1);
        } else {
            System.out.println("Você perdeu! O número era: " + numeroAleatorio);
            jogador.setPontuacao(jogador.getPontuacao() - 1);
        }

        numeroJogadas++;
    }


    private void atualizarMelhorJogador(Jogador jogador) {
        if (melhorJogador == null || jogador.getPontuacao() > melhorJogador.getPontuacao()) {
            melhorJogador = jogador;
        }
    }

    public void exibirRankingCompleto(List<Jogador> jogadores) {
        System.out.println("Ranking completo:");
        jogadores.sort(Comparator.comparing(Jogador::getPontuacao).reversed());
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + " - " + jogador.getPontuacao() + " pontos");
        }
    }

    public void exibirTop10(List<Jogador> jogadores) {
        System.out.println("Top 10 jogadores:");
        jogadores.sort(Comparator.comparing(Jogador::getPontuacao).reversed());
        for (int i = 0; i < Math.min(10, jogadores.size()); i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println(jogador.getNome() + " - " + (i + 1));
        }
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }

    public Jogador getMelhorJogador() {
        return melhorJogador;
    }
}
