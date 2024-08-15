package chess.pecas;

import boardgame.Tabuleiro;
import chess.PecaXadrez;
import chess.enums.Cor;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] movimentos = new boolean[getTabuleiro().getRows()][getTabuleiro().getCols()];
        return movimentos;
    }
}
