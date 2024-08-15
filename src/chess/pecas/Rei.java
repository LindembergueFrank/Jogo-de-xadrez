package chess.pecas;

import boardgame.Tabuleiro;
import chess.PecaXadrez;
import chess.enums.Cor;

public class Rei extends PecaXadrez {

    public Rei(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] movimentos = new boolean[getTabuleiro().getRows()][getTabuleiro().getCols()];
        return movimentos;
    }
}
