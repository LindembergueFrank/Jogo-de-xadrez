# Xadrez em Java — projeto de estudo

Aplicação de console para praticar programação orientada a objetos e modelagem de regras de tabuleiro.

## Implementação atual

- Tabuleiro 8 × 8 e conversão de coordenadas.
- Peças Rei e Torre.
- Turnos, movimentos, capturas e validação da origem/destino.
- Lógica de xeque e xeque-mate.
- Interface de terminal com tratamento de entradas inválidas.

O cenário inicial utiliza apenas reis e torres. Peões, bispos, cavalos, dama e regras associadas à partida completa não estão implementados nesta versão.

## Organização

| Diretório | Conteúdo |
| --- | --- |
| [src/application](src/application/) | Entrada da aplicação: `application.Main`. |
| [src/boardgame](src/boardgame/) | Abstrações de tabuleiro, posições e peças. |
| [src/chess](src/chess/) | Regras, interface de console e peças de xadrez. |

## Executar

Utilize JDK 17 ou superior. No Linux/macOS, na raiz:

```sh
javac -d out $(find src -name '*.java')
java -cp out application.Main
```

No PowerShell:

```powershell
$fontesJava = (Get-ChildItem src -Recurse -Filter *.java).FullName
javac -d out $fontesJava
java -cp out application.Main
```

Digite a coordenada de origem e depois a de destino, conforme os pedidos do terminal.

## Conceitos praticados

Encapsulamento, herança, polimorfismo, composição, enums, matrizes, exceções e separação das responsabilidades de apresentação e domínio.

## Autor

Lindembergue Frank.
