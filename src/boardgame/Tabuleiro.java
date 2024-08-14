package boardgame;

public class Tabuleiro {
    private int rows;
    private int cols;
    private Peca[][] pecas;

    public Tabuleiro(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        pecas = new Peca[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
