package chess;

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

    private void colocarNovaPeca(char col, int row, PecaXadrez peca){
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(col, row).paraPosicao());
    }

    private void iniciarJogo() {
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
    }
}
