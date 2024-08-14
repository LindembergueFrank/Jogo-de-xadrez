package chess;

import boardgame.Tabuleiro;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] pecaDaPartida = new PecaXadrez[tabuleiro.getRows()][tabuleiro.getCols()];
        for (int i=0; i<tabuleiro.getRows(); i++) {
            for (int j=0; j<tabuleiro.getCols(); j++) {
                // Dowcasting
                pecaDaPartida[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return pecaDaPartida;
    }
}
