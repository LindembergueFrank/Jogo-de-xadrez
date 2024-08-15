package application;


import chess.PartidaXadrez;
import chess.PecaXadrez;
import chess.PosicaoXadrez;
import chess.UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while (true){
            UI.imprimirTabuleiro(partidaXadrez.getPecas());

            System.out.println();
            System.out.println("Origem: ");
            PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

            System.out.println();
            System.out.println("Destino: ");
            PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

            PecaXadrez pecaCapturada = partidaXadrez.realizarJogadaXadrez(origem, destino);
        }

    }
}