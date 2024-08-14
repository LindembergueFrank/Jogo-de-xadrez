package chess;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.enums.Cor;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        iniciarJogo();
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

    private void iniciarJogo() {
        tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.BLACK), new Posicao(1,6));
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.WHITE), new Posicao(7,4));
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.WHITE), new Posicao(7,4));
    }
}
