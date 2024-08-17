package chess;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.enums.Cor;
import chess.exceptions.XadrezException;
import chess.pecas.Rei;
import chess.pecas.Torre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartidaXadrez {
    private int turno;
    private Cor jogadorAtual;
    private Tabuleiro tabuleiro;
    private boolean check;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas= new ArrayList<>();

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

    public boolean getCheck(){
        return check;
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

    public PecaXadrez realizarJogadaXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
        Posicao origem = posicaoOrigem.paraPosicao();
        Posicao destino = posicaoDestino.paraPosicao();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = realizarMovimento(origem, destino);

        // Testa se o movimento coloca o jogador atual em cheque
        if (testeCheck(jogadorAtual)) {
            desfazerMovimento(origem, destino, pecaCapturada);
            throw new XadrezException("Você não pode se colocar em cheque");
        }

        // Verifica se o oponente está em cheque
        check = (testeCheck(oponente(jogadorAtual))) ? true : false;

        proximoTurno();
        return (PecaXadrez) pecaCapturada;
    }


    public boolean[][] possiveisMovimentos(PosicaoXadrez posicaoOrigem) {
        Posicao posicao = posicaoOrigem.paraPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).possiveisMovimentos();
    }

    private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
        Peca pecaMovida = tabuleiro.removerPeca(destino);
        if (pecaMovida == null) {
            throw new XadrezException("Erro ao desfazer movimento: nenhuma peça encontrada na posição de destino.");
        }
        tabuleiro.colocaPeca(pecaMovida, origem);

        if (pecaCapturada != null) {
            tabuleiro.colocaPeca(pecaCapturada, destino);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
    }

    private Peca realizarMovimento(Posicao origem, Posicao destino){
        Peca pecaAux = tabuleiro.removerPeca(origem);
        Peca capturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocaPeca(pecaAux, destino);

        if (capturada != null){
            pecasNoTabuleiro.remove(capturada);
            pecasCapturadas.add(capturada);
        }

        return capturada;
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
        pecasNoTabuleiro.add(peca);
    }

    private Cor oponente(Cor cor){
        return (cor == Cor.BRANCAS) ? Cor.PRETAS : Cor.BRANCAS;
    }

    private PecaXadrez rei(Cor cor){
        List<Peca> listaPecas = pecasNoTabuleiro
                .stream()
                .filter(x -> ((PecaXadrez)x).getCor()==cor)
                .toList();

        for (Peca peca : listaPecas) {
            if (peca instanceof Rei){
                return (PecaXadrez) peca;
            }
        }
        // Nunca pode cair nesta exceção
        throw new IllegalStateException("Nao existe o rei da cor " + cor + " no tabuleiro");
    }

    private boolean testeCheck (Cor cor){
        Posicao posicaoRei = rei(cor).getPosicaoXadrez().paraPosicao();
        List<Peca> pecasOponente = pecasNoTabuleiro
                .stream()
                .filter(x -> ((PecaXadrez)x).getCor()==oponente(cor))
                .toList();

        for (Peca peca : pecasOponente){
            boolean[][] movimentos = peca.possiveisMovimentos();
            if (movimentos[posicaoRei.getRow()][posicaoRei.getColumn()]){
                return true;
            }
        }
        return false;
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
