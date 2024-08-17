package chess;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.enums.Cor;

public abstract class PecaXadrez extends Peca {
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public PosicaoXadrez getPosicaoXadrez() {
        return PosicaoXadrez.daPosicao(posicao);
    }

    public Cor getCor() {
        return cor;
    }

    protected boolean existePecaOponente (Posicao posicao) {
        PecaXadrez pecaAux = (PecaXadrez) getTabuleiro().peca(posicao);
        return pecaAux != null && pecaAux.getCor() != cor;
    }
}
