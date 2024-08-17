package chess;

import chess.enums.Cor;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {

    //<a href="https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println">Referencia</a>

    // Cores do texto
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Cores do fundo
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {

        try {
            String leitura = sc.nextLine();
            char col = leitura.charAt(0);
            // Recortar string para receber a linha
            int row = Integer.parseInt(leitura.substring(1));
            return new PosicaoXadrez(col, row);
        }
        catch(RuntimeException e) {
            throw new InputMismatchException("Erro ao instanciar posicao no xadrez. " +
                    "Valores válidos deve ser entre A1 a H8.");
        }

    }

    public static void imprimirPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> pecasCapturadas) {
        imprimirTabuleiro(partidaXadrez.getPecas());
        System.out.println();
        imprimirPecasCapturadas(pecasCapturadas);
        System.out.println();
        System.out.println("Turno: " + partidaXadrez.getTurno());
        System.out.println("Aguardando jogador(a) das peças: " + partidaXadrez.getJogadorAtual());

        if(partidaXadrez.getCheck()){
            System.out.println("Jogador atual esta em CHEQUE!");
        }
    }

    public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                imprimirPeca(pecas[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }


    public static void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] possiveisMovimentos) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                imprimirPeca(pecas[i][j], possiveisMovimentos[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void imprimirPeca (PecaXadrez peca , boolean fundo) {
        if (fundo){
            System.out.print(ANSI_GREEN_BACKGROUND);
        }
        if (peca == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (peca.getCor() == Cor.BRANCAS) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    // <a href="https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java">Referencia</a>
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void imprimirPecasCapturadas(List<PecaXadrez> pecasCapturadas){
        List<PecaXadrez> pecasBrancas = pecasCapturadas
                .stream()
                .filter(x -> x.getCor() == Cor.BRANCAS)
                .toList();

        List<PecaXadrez> pecasPretas = pecasCapturadas
                .stream()
                .filter(x -> x.getCor() == Cor.PRETAS)
                .toList();

        System.out.println("Pecas capturadas");
        System.out.print("Brancas: ");
        System.out.print(ANSI_WHITE);
        System.out.print(Arrays.toString(pecasBrancas.toArray()));
        System.out.println(ANSI_RESET);

        System.out.print("Pretas: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(pecasPretas.toArray()));
        System.out.print(ANSI_RESET);
    }
}
