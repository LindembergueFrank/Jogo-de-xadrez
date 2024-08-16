package chess;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.exceptions.TabuleiroException;
import chess.enums.Cor;
import chess.exceptions.XadrezException;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class PartidaXadrez {
    private int turno;
    private Cor jogadorAtual;
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        turno = 1;
        jogadorAtual = Cor.BRANCAS;
        iniciarJogo();
    }

    public int getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
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

    public PecaXadrez realizarJogadaXadrez (PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.paraPosicao();
        Posicao destino = posicaoDestino.paraPosicao();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = realizarMovimento(origem, destino);
        proximoTurno();
        return (PecaXadrez) pecaCapturada;
    }

    public boolean[][] possiveisMovimentos(PosicaoXadrez posicaoOrigem) {
        Posicao posicao = posicaoOrigem.paraPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).possiveisMovimentos();
    }

    private Peca realizarMovimento(Posicao origem, Posicao destino){
        Peca pecaAux = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocaPeca(pecaAux, destino);
        return pecaCapturada;
    }

    private void validarPosicaoOrigem(Posicao posicao) {
        if (!tabuleiro.haUmPeca(posicao)){
            throw new XadrezException("Nao ha peca na posicao de origem");
        }
        if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()){
            throw new XadrezException("A peca escolhida nao eh sua");
        }
        if (!tabuleiro.peca(posicao).existeMovimentoPossivel()){
            throw new XadrezException("Nao existe movimentos possiveis para esta peca");
        }
    }

    private void validarPosicaoDestino(Posicao origem, Posicao destino){
        if (!tabuleiro.peca(origem).possiveisMovimentos(destino)){
            throw new XadrezException("A peca escolhida nao pode se mover para a posicao de destino");
        }
    }

    private void proximoTurno(){
        turno++;
        jogadorAtual = (jogadorAtual == Cor.BRANCAS) ? Cor.PRETAS : Cor.BRANCAS;
    }

    private void colocarNovaPeca(char col, int row, PecaXadrez peca){
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(col, row).paraPosicao());
    }

    private void iniciarJogo() {
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCAS));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCAS));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCAS));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETAS));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETAS));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETAS));
    }

}
