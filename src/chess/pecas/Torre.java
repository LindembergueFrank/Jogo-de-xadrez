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

        Posicao posicao = new Posicao(0, 0);

        // Acima da peca
        posicao.setValue(posicao.getRow() - 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().haUmPeca(posicao)){
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
            posicao.setRow(posicao.getRow() - 1);
        }
        if (getTabuleiro().posicaoExiste(posicao) && existePecaOponente(posicao)) {
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
        }

        // Abaixo da peca
        posicao.setValue(posicao.getRow() + 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().haUmPeca(posicao)){
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
            posicao.setRow(posicao.getRow() + 1);
        }
        if (getTabuleiro().posicaoExiste(posicao) && existePecaOponente(posicao)) {
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
        }

        // Esquerda da peca
        posicao.setValue(posicao.getRow(), posicao.getColumn() - 1);
        while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().haUmPeca(posicao)){
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
            posicao.setColumn(posicao.getColumn() - 1);
        }
        if (getTabuleiro().posicaoExiste(posicao) && existePecaOponente(posicao)) {
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
        }

        // Direita da peca
        posicao.setValue(posicao.getRow(), posicao.getColumn() + 1);
        while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().haUmPeca(posicao)){
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
            posicao.setColumn(posicao.getColumn() + 1);
        }
        if (getTabuleiro().posicaoExiste(posicao) && existePecaOponente(posicao)) {
            movimentos[posicao.getRow()][posicao.getColumn()] = true;
        }


        return movimentos;
    }
}
