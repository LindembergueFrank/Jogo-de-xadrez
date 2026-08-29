# Jogo de Xadrez em Java

Implementação de um jogo de xadrez em console desenvolvida como projeto de estudo de **Java e Programação Orientada a Objetos**.

O repositório é mantido como registro da evolução em modelagem orientada a objetos e regras de domínio. Ele não pretende ser uma aplicação de produção ou um produto final com interface gráfica.

## Conceitos praticados

- classes, objetos e encapsulamento;
- herança e polimorfismo;
- composição;
- enums;
- matrizes e coordenadas de tabuleiro;
- exceções;
- separação entre regras do tabuleiro e regras específicas do xadrez;
- implementação incremental de regras de negócio.

## Funcionalidades presentes

O código em `src/` cobre a estrutura do tabuleiro e peças, movimentação e regras do jogo implementadas ao longo do histórico, incluindo lógica relacionada a xeque e xeque-mate.

## Estrutura geral

```text
src/
├── boardgame/   # abstrações de tabuleiro, posição e peças
├── chess/       # regras e entidades específicas de xadrez
└── application/ # ponto de entrada e interação no console
```

A estrutura exata pode variar conforme a versão preservada no repositório.

## Executando

Este é um projeto Java simples. Compile os arquivos a partir do diretório `src` com uma JDK compatível ou importe o projeto em sua IDE preferida.

Exemplo genérico:

```bash
javac -d out $(find src -name "*.java")
java -cp out application.Program
```

No Windows, a forma de enumerar os arquivos Java varia conforme o shell; uma IDE pode ser a opção mais simples para este projeto de estudo.

## Higiene do repositório

Metadados específicos de IDE e arquivos gerados não são versionados. O `.gitignore` cobre IntelliJ IDEA, Eclipse/STS, NetBeans, VS Code e saídas de build.

## Papel no portfólio

Este projeto demonstra fundamentos de POO e modelagem de regras. Projetos backend autorais mais recentes devem ser considerados a principal evidência de engenharia de software, testes, segurança e operação.

## Autor

**Lindembergue Frank**
