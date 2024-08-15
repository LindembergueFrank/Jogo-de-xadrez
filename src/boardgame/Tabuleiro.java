package boardgame;

import boardgame.exceptions.TabuleiroException;

public class Tabuleiro {
    private int rows;
    private int cols;
    private Peca[][] pecas;

    public Tabuleiro(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new TabuleiroException("Erro ao gerar Tabuleiro: Necessario que haja " +
                    "pelo menos 1a linha e 1a coluna");
        }
        this.rows = rows;
        this.cols = cols;
        pecas = new Peca[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Peca peca(int rows, int cols){
        if (!posicaoExiste(rows, cols)) {
            throw new TabuleiroException("Nao ha esta posicao no tabuleiro");
        }
        return pecas[rows][cols];
    }

    public Peca peca(Posicao posicao){
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Nao ha esta posicao no tabuleiro");
        }
        return pecas[posicao.getRow()][posicao.getColumn()];
    }

    public void colocaPeca(Peca peca, Posicao posicao){
        if (haUmPeca(posicao)){
            throw new TabuleiroException("Ja existe uma pessa nesta posicao " + posicao);
        }
        pecas[posicao.getRow()][posicao.getColumn()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Nao ha esta posicao no tabuleiro");
        }
        if (peca(posicao) == null){
            return null;
        }

        Peca pecaAux = peca(posicao);
        pecaAux.posicao = null;
        pecas[posicao.getRow()][posicao.getColumn()] = null;
        return pecaAux;
    }

    private boolean posicaoExiste(int row, int col){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean posicaoExiste(Posicao posicao) throws TabuleiroException {
        return posicaoExiste(posicao.getRow(), posicao.getColumn());
    }

    public boolean haUmPeca(Posicao posicao){
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Nao ha esta posicao no tabuleiro");
        }
       return peca(posicao) != null;
    }
}
