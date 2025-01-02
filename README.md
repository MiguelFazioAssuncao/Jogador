# Jogo de Pedra, Papel, Tesoura

Este é um projeto simples em Java que implementa o clássico jogo de **Pedra, Papel, Tesoura**, permitindo que múltiplos jogadores participem de rodadas e acumulem pontos. O sistema também exibe rankings, permitindo visualizar os jogadores com melhores pontuações.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Jogadores**:
    - Adicionar até 10 jogadores.
    - Cada jogador escolhe uma jogada: Pedra, Papel ou Tesoura.
    - Os pontos são atribuídos com base no resultado de cada rodada.
- **Rodadas**:
    - Jogadores escolhem entre as opções: **Pedra**, **Papel** ou **Tesoura**.
    - O sistema gera uma jogada aleatória para competir com o jogador.
    - O vencedor é determinado pelas regras tradicionais do jogo:
        - Pedra vence Tesoura.
        - Tesoura vence Papel.
        - Papel vence Pedra.
        - Empate é possível.
- **Ranking**:
    - Visualização do ranking completo com todos os jogadores e suas pontuações.
    - Visualização dos 10 melhores jogadores.
- **Menu Interativo**:
    - O jogador pode escolher entre iniciar uma nova partida, ver o ranking completo, ver os top 10 ou sair do jogo.

## Estrutura do Projeto

### Classes Principais
- **Jogador**: Representa um jogador, com informações como nome e pontuação.
- **Jogo**: Gerencia a lógica do jogo, onde os jogadores escolhem suas jogadas e o sistema determina o vencedor.
- **Main**: A classe principal é responsável pela interação com o usuário, exibindo o menu e permitindo que o jogador escolha o que deseja fazer.

### Classe `Jogo`
A classe `Jogo` contém os métodos que permitem jogar uma rodada de "Pedra, Papel ou Tesoura", atualizar a pontuação dos jogadores e determinar o vencedor.

### Classe `Main`
A classe `Main` apresenta o menu interativo, onde o jogador pode:
- Iniciar uma partida.
- Ver o ranking completo.
- Ver os 10 melhores jogadores.
- Sair do jogo.

## Tecnologias e Conceitos Utilizados

- **Java**: Linguagem de programação utilizada.
- **POO (Programação Orientada a Objetos)**: Utilização de classes e objetos para representar jogadores e o jogo.
- **Coleções Java**: Uso de `ArrayList` para armazenar os jogadores.
- **Scanner**: Para entrada de dados do usuário.
- **Estruturas de controle**: Uso de `switch` para navegação no menu e controle das opções.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git 
   ```
2. Compile os arquivos Java:
   ```bash
   javac src/main/**/*.java  
   ```
2. Execute o programa:
   ```bash
   java src.main.Main
   ```
   
### Exemplo de entrada

Escolha uma das opções:

1 - Iniciar partida  
2 - Ver ranking completo  
3 - Ver top 10  
4 - Sair

`Iniciar partida:` O jogador escolhe uma jogada e disputa com o sistema.  
`Ver ranking completo:` Exibe todos os jogadores com suas pontuações.  
`Ver top 10:` Exibe os 10 jogadores com maiores pontuações.  
`Sair:` Encerra o jogo.  

### Exemplo de saída  
Após a partida:

Escolha uma das opções:

1 - Jogar novamente  
2 - Ver ranking completo  
3 - Ver top 10  
4 - Sair

Ranking Completo:

Lista de jogadores:
    João - 3 pontos  
    Maria - 2 pontos  
    José - 1 ponto  

Top 10:

João - 1
Maria - 2