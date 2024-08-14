package application;


import chess.PartidaXadrez;
import chess.UI;

public class Main {
    public static void main(String[] args) {
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        UI.imprimirTabuleiro(partidaXadrez.getPecas());
    }
}