# Campo Minado

Esse é o básico e simples jogo de Campo Minado, onde o objetivo é marcar as bombas e abrir os campos numerados para ganhar. O jogo foi desenvolvido puramente em Java.

## Informações

Neste projeto, foram utilizados 4 pacotes com funcionalidades distintas:

### 1. **Pacote Modelo**
Responsável pela criação e manutenção das classes `Campo` e `Tabuleiro`, além dos respectivos métodos.

### 2. **Pacote Excecao**
Responsável pela criação e manutenção das exceções personalizadas que podem ser geradas durante o jogo. As exceções são usadas para tratar erros específicos, como tentativas de abrir um campo inválido ou marcar um campo já revelado.

### 3. **Pacote Visao**
Esse pacote gerencia as opções gerais do jogo, além do visual apresentado no console. Ele é responsável por exibir o estado atual do tabuleiro para o jogador, além de receber as entradas do usuário para fazer suas jogadas.

### 4. **Pacote Main**
Responsável exclusivamente pela execução do jogo. O método `main` controla o fluxo do jogo, interage com os outros pacotes e executa a lógica de início, andamento e término da partida.

## Como Funciona
![png do Console](https://github.com/Igor-raphael/Campo-Minado/blob/main/Console.png)
1. O tabuleiro é gerado ao decidir quantas linhas, colunas e bombas definidas na classe `main`, as bombas são distribuídas aleatoriamente pelo tabuleiro.
~~~java
Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
~~~
Nesse caso teremos respectivamente 6 linhas (de 0 a 5), 6 colunas (de 0 a 5) e 6 bombas nesse tabuleiro. 

2. O jogador deve marcar onde acredita que as bombas estão localizadas, enquanto tenta abrir os campos numéricos, que indicam a quantidade de bombas nas células adjacentes, havendo as coordenadas X que são as linhas e Y sendo suas colunas.
3. O jogo termina quando o jogador abre uma célula contendo uma bomba ou quando marca todas as bombas corretamente.

## Objetivo

O objetivo do jogo é **não detonar nenhuma bomba** enquanto tenta descobrir todas as células seguras, marcando as bombas corretamente.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação utilizada para implementar o jogo.
- **Console:** Interface de usuário por meio de texto no console.

## Como Executar

Para rodar o jogo, basta compilar e executar o arquivo principal da classe `Main`.

```bash
javac Main.java
java Main
