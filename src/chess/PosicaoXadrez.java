package chess;

import boardgame.Posicao;
import chess.exceptions.XadrezException;

public class PosicaoXadrez {
    private char col;
    private int row;

    public PosicaoXadrez(char col, int row) {
        if (col < 'A' && col > 'H' || row < 1 || row > 8) {
            throw new XadrezException("Erro ao instanciar posicao no xadrez. " +
                    "Valores válidos deve ser entre A1 a H8.");
        }
        this.col = col;
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    /**
    * cálculo para linha do tabuleiro:  8-row
    * cálculo para coluna do tabuleiro: col-a
    *
    * @return retorno uma nova posicao
    * @version 1.0
    */
    protected Posicao paraPosicao() {
        return new Posicao(8-row, col-'a');
    }

    protected static PosicaoXadrez daPosicao(Posicao posicao) {
        // Casting
        return new PosicaoXadrez((char) ('a'+posicao.getColumn()), 8-posicao.getRow());
    }

    @Override
    public String toString() {
        return "" + col + row;
    }
}
