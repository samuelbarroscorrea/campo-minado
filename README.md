# Campo Minado

Projeto desenvolvido em **Java** com **Swing**, com o objetivo de praticar programação orientada a objetos, lógica de programação e desenvolvimento de interfaces gráficas.

O projeto recria o clássico jogo **Campo Minado**, permitindo ao jogador revelar campos, marcar possíveis bombas e tentar concluir o tabuleiro sem explodir nenhuma delas.

## 🎮 Mecânica

Além das mecânicas tradicionais do Campo Minado, o projeto possui uma regra adicional:

* A cada **5 movimentos**, as bombas não marcadas são redistribuídas pelo tabuleiro.
* Bombas não podem ser colocadas em campos que já foram descobertos.
* As bombas **marcadas corretamente ficam congeladas** e não mudam mais de posição.
* Após cada redistribuição, os números dos campos já descobertos são atualizados de acordo com as novas posições das bombas.
* O contador de movimentos é reiniciado após cada redistribuição.

Essa mecânica adiciona uma camada estratégica ao jogo, pois o jogador precisa identificar e marcar corretamente o maior número possível de bombas para reduzir a quantidade de bombas que continuam se movimentando.

## 🛠️ Tecnologias

* **Java**
* **Java Swing**
* **Programação Orientada a Objetos**
* **Git / GitHub**

## 📚 Conceitos praticados

Durante o desenvolvimento foram utilizados conceitos como:

* Classes e objetos
* Encapsulamento
* Interfaces
* Composição
* Listas e coleções
* Expressões lambda
* Streams
* Eventos e observadores
* Estruturas condicionais e de repetição
* Manipulação de interfaces gráficas com Swing

## ▶️ Como executar

Clone o repositório:

```bash
git clone https://github.com/samuelbarroscorrea/campo-minado.git
```

Abra o projeto em uma IDE compatível com Java e execute a classe:

```text
br.com.coder.cm.visao.TelaPrincipal
```

## 🎯 Objetivo

O projeto foi desenvolvido como uma atividade prática para aplicar conceitos de **Java e Programação Orientada a Objetos**, além de exercitar a modificação e evolução de uma aplicação existente através da implementação de novas regras de negócio.
