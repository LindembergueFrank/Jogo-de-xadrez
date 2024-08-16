package chess.pecas;

import boardgame.Posicao;
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

        Posicao posicaoAux = new Posicao(0, 0);

        // Acima da peca
        posicaoAux.setValue(posicao.getRow() - 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(posicaoAux) && !getTabuleiro().haUmPeca(posicaoAux)){
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
            posicaoAux.setRow(posicaoAux.getRow() - 1);
        }
        if (getTabuleiro().posicaoExiste(posicaoAux) && existePecaOponente(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Abaixo da peca
        posicaoAux.setValue(posicao.getRow() + 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(posicaoAux) && !getTabuleiro().haUmPeca(posicaoAux)){
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
            posicaoAux.setRow(posicaoAux.getRow() + 1);
        }
        if (getTabuleiro().posicaoExiste(posicaoAux) && existePecaOponente(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Esquerda da peca
        posicaoAux.setValue(posicao.getRow(), posicao.getColumn() - 1);
        while (getTabuleiro().posicaoExiste(posicaoAux) && !getTabuleiro().haUmPeca(posicaoAux)){
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
            posicaoAux.setColumn(posicaoAux.getColumn() - 1);
        }
        if (getTabuleiro().posicaoExiste(posicaoAux) && existePecaOponente(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }

        // Direita da peca
        posicaoAux.setValue(posicao.getRow(), posicao.getColumn() + 1);
        while (getTabuleiro().posicaoExiste(posicaoAux) && !getTabuleiro().haUmPeca(posicaoAux)){
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
            posicaoAux.setColumn(posicaoAux.getColumn() + 1);
        }
        if (getTabuleiro().posicaoExiste(posicaoAux) && existePecaOponente(posicaoAux)) {
            movimentos[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
        }


        return movimentos;
    }
}
