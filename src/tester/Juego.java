/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tester.piezas.*;

/**
 *
 * @author botxxxga
 */
public class Juego {

    private int elTurno;

    /**
     * Devuelve el valor del atributo turno
     *
     * @return Devuelve el turno del Juego
     */
    public int getTurno() {
        return elTurno;
    }

    /**
     * Asigna un nuevo valor al atributo turno
     *
     * @param turno nuevo valor del turno
     */
    public void setTurno(int turno) {
        this.elTurno = turno;
    }

    /**
     * Constructor para iniciar el juego
     *
     */
    public Juego() {
        elTurno = 0;
    }

    /**
     * Crea un movimiento mediante la jugada del jugador
     *
     * @param jugada Eleccion del jugador que se pide en el método pedirJugada
     * @return Devuelve un movimiento crado mediante la jugada introducida
     */
    public Movimiento jugada(String jugada) {
        Posicion posInicial = new Posicion(((int) jugada.charAt(0)) - 65, (((int) jugada.charAt(1)) - 49));
        Posicion posFinal = new Posicion(((int) jugada.charAt(2)) - 65, (((int) jugada.charAt(3)) - 49));
        return new Movimiento(posInicial, posFinal);
    }

    /**
     * Metodo que prepara para mover pieza en el tablero
     *
     * @param mov Movimiento elegido del jugador
     * @param tablero Tablero del ajedrez
     */
    public void moverJuego(Movimiento mov, Tablero tablero) {
        tablero.moverPieza(mov);

    }

    /**
     * Pide Jugada al jugador
     *
     * @param ajedrez Tablero de Ajedrez
     * @return Devuelve la eleccion del jugador, no sin antes comprobar si todo
     * es correcto
     * @throws IOException
     */
    public String pedirJugada(Tablero ajedrez, int turno) throws IOException {
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        String eleccion = "0";
        do {
            System.out.print("Introduce jugada [A1H8]:");
            eleccion = scb.readLine().toUpperCase();
            if (controlFormatoJugada(eleccion) && !eleccion.equalsIgnoreCase("FIN")) {
                System.out.println("Has introducido mal el formato. Ej: C1F4");
            } 
            else if (!controlTurno(eleccion, ajedrez, turno)) {
                System.out.println("No es tu pieza");
            }else if (controlPiezaInicioJugada(eleccion, ajedrez)) {
                System.out.println("En la posicion del inicio no hay pieza para mover");
            } else if (controlPiezaFinalJugada(eleccion, ajedrez)) {
                System.out.println("En la posicion de destino hay una pieza de tu color");
            } else if (!controlValidoMovimiento(eleccion, ajedrez)) {
                System.out.println("El movimiento no es valido de la pieza");
            } else if (ajedrez.hayPiezasEntre(jugada(eleccion))) {
                System.out.println("El movimiento no es valido porque hay piezas entre");
            } 

        } while (controlFormatoJugada(eleccion) || controlPiezaInicioJugada(eleccion, ajedrez) || controlPiezaInicioJugada(eleccion, ajedrez) || controlPiezaFinalJugada(eleccion, ajedrez) || !controlValidoMovimiento(eleccion, ajedrez) || ajedrez.hayPiezasEntre(jugada(eleccion)) || !controlTurno(eleccion, ajedrez, turno));
        return eleccion;
    }

    /**
     * Controla el usuario para que introduzca solo 4 letras y las columnas
     * [A-H] y filas [1-8]
     *
     * @param eleccion Introducido por el jugador
     * @return Devuelve true si un fallo se cumple, devuelve false si todo es
     * correcto
     */
    public boolean controlFormatoJugada(String eleccion) {
        return eleccion.length() != 4 || !(eleccion.charAt(0) >= 'A' && eleccion.charAt(0) <= 'H') || !(eleccion.charAt(2) >= 'A' && eleccion.charAt(2) <= 'H') || !(eleccion.charAt(1) >= '1' && eleccion.charAt(1) <= '8') || !(eleccion.charAt(3) >= '1' && eleccion.charAt(3) <= '8');
    }

    /**
     * Controla al usuario para que NO introduzca una casilla de inicio vacia
     *
     * @param eleccion Introducio por el jugador
     * @param ajedrez Tablero ajedrez
     * @return Devuelve true si en la casilla no hay objeto, devuelve false si
     * hay objeto
     */
    public boolean controlPiezaInicioJugada(String eleccion, Tablero ajedrez) {
        return !ajedrez.hayPieza(((int) eleccion.charAt(1)) - 49, ((int) eleccion.charAt(0)) - 65);
    }

    public boolean controlTurno(String eleccion, Tablero ajedrez, int turno) {
        if (turno == 0 && ajedrez.tablero[((int) eleccion.charAt(1)) - 49][((int) eleccion.charAt(0)) - 65].color.equals("blanco")) return true;
        else return turno == 1 && ajedrez.tablero[((int) eleccion.charAt(1)) - 49][((int) eleccion.charAt(0)) - 65].color.equals("negro");

    }

    /**
     * Controla al usuario por si en la Posicion Final hay una pieza de su color
     * no pueda mover a esa posicion
     *
     * @param eleccion Introducio por el jugador
     * @param ajedrez Tablero ajedrez
     * @return Devuelve true si hay pieza de mismo color en la posicion final,
     * devulve false si no hay pieza
     */
    public boolean controlPiezaFinalJugada(String eleccion, Tablero ajedrez) {
        return ajedrez.hayPieza((((int) eleccion.charAt(3)) - 49), ((int) eleccion.charAt(2)) - 65) && ajedrez.tablero[((int) eleccion.charAt(1)) - 49][((int) eleccion.charAt(0)) - 65].color.equals(ajedrez.tablero[((int) eleccion.charAt(3)) - 49][((int) eleccion.charAt(2)) - 65].color);
    }

    /**
     * Controla al usuario por si introduce un movimiento no valido a la pieza
     * mover
     *
     * @param eleccion Introducido por el jugador
     * @param ajedrez Tablero ajedrez
     * @return Devuelve true si el movimiento de la pieza es valido, devulve
     * false si no es valido
     */
    public boolean controlValidoMovimiento(String eleccion, Tablero ajedrez) {
        return ajedrez.tablero[((int) eleccion.charAt(1)) - 49][((int) eleccion.charAt(0)) - 65].validoMovimiento(jugada(eleccion));
    }
}
