package boardgame;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] possiveisMovimentos();

    public boolean possiveisMovimentos(Posicao posicao) {
        return possiveisMovimentos()[posicao.getRow()][posicao.getColumn()];
    }

    public boolean existeMovimentoPossivel() {
        boolean[][] movimentos = possiveisMovimentos();

        for(int i=0; i<movimentos.length; i++) {
            for(int j=0; j<movimentos.length; j++) {
                if(movimentos[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
