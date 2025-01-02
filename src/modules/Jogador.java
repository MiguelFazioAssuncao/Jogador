package modules;

public class Jogador {
    private String nome;
    private int idade;
    private double pontuacao;
    private int numeroTentativas;


    public Jogador() {
    }

    public Jogador(String nome, int idade, double pontuacao, int numeroTentativas) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
        this.numeroTentativas = numeroTentativas;
    }


    public void adicionarPontos() {
        pontuacao++;
    }

    public void perdePontos() {
        pontuacao--;
    }

    public void adicionaTentativas() {
        numeroTentativas++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }
}
