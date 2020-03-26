/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author botxxxga
 */
public class tester {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        Tablero ajedrez = new Tablero();
        Juego partida = new Juego();
        boolean salida = false;
        System.out.print("Nombre jugador 1: ");
        String player1 = scb.readLine();
        System.out.print("Nombre jugador 2: ");
        String player2 = scb.readLine();
        do {

            ajedrez.pintar();
            System.out.println((partida.getTurno() == 0) ? player1 : player2);
            partida.moverJuego(partida.jugada(partida.pedirJugada(ajedrez,partida.getTurno()).toUpperCase()), ajedrez);
            partida.setTurno((partida.getTurno() == 0) ? 1 : 0);
        } while (salida == false);
    }
}
