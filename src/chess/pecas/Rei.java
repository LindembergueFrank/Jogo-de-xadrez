package chess.pecas;

import boardgame.Posicao;
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

    private boolean podeMover (Posicao posicao) {
        PecaXadrez pecaXadrez = (PecaXadrez) getTabuleiro().peca(posicao);
        return pecaXadrez == null || pecaXadrez.getCor() != getCor();
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] movimentos = new boolean[getTabuleiro().getRows()][getTabuleiro().getCols()];

        Posicao posicaoAux = new Posicao(0, 0);

        // Acima da peca
        posicaoAux.setValue(posicao.getRow() - 1, posicao.getColumn());
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Abaixo da peca
        posicaoAux.setValue(posicao.getRow() + 1, posicao.getColumn());
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Esquerda da peca
        posicaoAux.setValue(posicao.getRow(), posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Direita da peca
        posicaoAux.setValue(posicao.getRow(), posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Diagonal superior esquerda da peca
        posicaoAux.setValue(posicao.getRow() - 1, posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Diagonal superior direita da peca
        posicaoAux.setValue(posicao.getRow() - 1, posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Diagonal inferior esquerda da peca
        posicaoAux.setValue(posicao.getRow() + 1, posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Diagonal inferior direita da peca
        posicaoAux.setValue(posicao.getRow() + 1, posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(posicaoAux) && podeMover(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        return movimentos;
    }
}
