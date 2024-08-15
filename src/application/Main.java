package application;


import chess.PartidaXadrez;
import chess.PecaXadrez;
import chess.PosicaoXadrez;
import chess.UI;
import chess.exceptions.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while (true){
            try{
                UI.limparTela();
                UI.imprimirTabuleiro(partidaXadrez.getPecas());

                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.realizarJogadaXadrez(origem, destino);
                System.out.println();
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

    }
}