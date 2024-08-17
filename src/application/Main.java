package application;


import chess.PartidaXadrez;
import chess.PecaXadrez;
import chess.PosicaoXadrez;
import chess.UI;
import chess.exceptions.XadrezException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();

        while (!partidaXadrez.isCheckMate()){
            try{
                UI.limparTela();
                UI.imprimirPartida(partidaXadrez, capturadas);

                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
                System.out.println();

                boolean[][] possiveisMovimentos = partidaXadrez.possiveisMovimentos(origem);
                UI.limparTela();
                UI.imprimirTabuleiro(partidaXadrez.getPecas(), possiveisMovimentos);

                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.realizarJogadaXadrez(origem, destino);
                System.out.println();

                if (pecaCapturada != null){
                    capturadas.add(pecaCapturada);
                }
            }
            catch (XadrezException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        UI.limparTela();
        UI.imprimirPartida(partidaXadrez, capturadas);

    }
}