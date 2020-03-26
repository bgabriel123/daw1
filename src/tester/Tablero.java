/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import tester.piezas.Alfil;
import tester.piezas.Caballo;
import tester.piezas.Peon;
import tester.piezas.Reina;
import tester.piezas.Rey;
import tester.piezas.Torre;

/**
 *
 * @author botxxxga
 */
public class Tablero {

    Pieza[][] tablero;
    
    public Tablero(){
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre("negro");
        tablero[0][1] = new Caballo("negro");
        tablero[0][2] = new Alfil("negro");
        tablero[0][3] = new Reina("negro");
        tablero[0][4] = new Rey("negro");
        tablero[0][5] = new Alfil("negro");
        tablero[0][6] = new Caballo("negro");
        tablero[0][7] = new Torre("negro");
        for (int i = 0; i < tablero[1].length; i++) {
            tablero[1][i] = new Peon("negro");
        }
        //*
        //FICHAS NEGRAS 
        for (int i = 0; i < tablero[6].length; i++) {
            tablero[6][i] = new Peon("blanco");
        }
        tablero[7][0] = new Torre("blanco");
        tablero[7][1] = new Caballo("blanco");
        tablero[7][2] = new Alfil("blanco");
        tablero[7][3] = new Rey("blanco");
        tablero[7][4] = new Reina("blanco");
        tablero[7][5] = new Alfil("blanco");
        tablero[7][6] = new Caballo("blanco");
        tablero[7][7] = new Torre("blanco");
    }
    
    
    /**
     * Muestra en pantalla el tablero
     *
     * @param tablero Tablero a pintar en pantalla
     */
    public void pintar() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].nombre + "|");
                } else {
                    System.out.print(" |");
                }

            }
            System.out.println("");
        }
    }
    
    /**
     * Comprueba si hay pieza en la casilla del tablero, mediante fila y columna
     *
     * @param fila Fila de la casilla del tablero
     * @param columna Columna de la casilla del tablero
     * @return devuelve true si hay pieza, devuelve false si no hay pieza
     */
    public boolean hayPieza(int fila, int columna) {
        return tablero[fila][columna] != null;
    }

    /**
     * Comprueba si hay pieza en la casilla del tablero, mediante una posicion
     *
     * @param pos Posicion en la que comprobar si hay pieza
     * @return devuelve true si hay pieza, devuelve false si no hay pieza
     */
    public boolean hayPieza(Posicion pos) {
        return tablero[pos.getFila()][pos.getColumna()] != null;
    }

    /**
     * Comprueba si hay pìeza en las casillas por la que pasa la pieza
     *
     * @param mov Movimiento de la pieza
     * @return devuelve true si hay una pieza, devuelve false si no hay pieza
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        boolean salida = false;
        int filaMenor, filaMayor, columnaMenor, columnaMayor;
        if (!tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()].getClass().getSimpleName().equalsIgnoreCase("Caballo")) {
            if (mov.esVertical()) {
                if (mov.posInicial.getFila() > mov.posFinal.getFila()) {
                    filaMenor = mov.posFinal.getFila();
                    filaMayor = mov.posInicial.getFila();
                } else {
                    filaMenor = mov.posInicial.getFila();
                    filaMayor = mov.posFinal.getFila();
                }
                for (int i = filaMenor + 1; i < filaMayor && salida != true; i++) {
                    if (hayPieza(i, mov.posInicial.getColumna())) {
                        salida = true;
                    }
                }
            } else if (mov.esHorizontal()) {
                if (mov.posInicial.getColumna() > mov.posFinal.getColumna()) {
                    columnaMenor = mov.posFinal.getColumna();
                    columnaMayor = mov.posInicial.getColumna();
                } else {
                    columnaMenor = mov.posInicial.getColumna();
                    columnaMayor = mov.posFinal.getColumna();
                }
                for (int i = columnaMenor + 1; i < columnaMayor && salida != true; i++) {
                    if (hayPieza(mov.posInicial.getFila(), i)) {
                        salida = true;
                    }

                }

            } else if (mov.esDiagonal()){
                if (mov.posInicial.getColumna()> mov.posFinal.getColumna()&& mov.posInicial.getFila()>mov.posFinal.getFila()) {
                    columnaMenor=mov.posFinal.getColumna();
                    columnaMayor=mov.posInicial.getColumna();
                    filaMenor=mov.posFinal.getFila();
                    filaMayor=mov.posInicial.getFila();
                } else if (mov.posInicial.getColumna()> mov.posFinal.getColumna()&& mov.posFinal.getFila()>mov.posInicial.getFila()){
                    columnaMenor=mov.posFinal.getColumna();
                    columnaMayor=mov.posInicial.getColumna();
                    filaMenor=mov.posInicial.getFila();
                    filaMayor=mov.posFinal.getFila();
                } else if (mov.posFinal.getColumna()> mov.posInicial.getColumna()&& mov.posInicial.getFila()>mov.posFinal.getFila()) {
                    columnaMenor=mov.posInicial.getColumna();
                    columnaMayor=mov.posFinal.getColumna();
                    filaMenor=mov.posFinal.getFila();
                    filaMayor=mov.posInicial.getFila();
                } else {
                    columnaMenor=mov.posInicial.getColumna();
                    columnaMayor=mov.posFinal.getColumna();
                    filaMenor=mov.posInicial.getFila();
                    filaMayor=mov.posFinal.getFila();
                }
                
                for (int i = filaMenor+1; i < filaMayor && salida!=true; i++) {
                    for (int j = columnaMenor+1; j < columnaMayor; j++) {
                        if (hayPieza(i,j)) {
                            salida=true;
                        }
                    }
                }
            }
        }
        return salida;

    }

    /**
     * Pone una pieza en el tablero, mediante fila y columna
     *
     * @param figura Pieza a poner
     * @param fila Fila de la casilla
     * @param columna Columna de la casilla
     */
    public void ponPieza(Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }

    /**
     * Pone una pieza en el tablero, mediante una posicion
     *
     * @param figura Pieza a poner
     * @param pos Posicion en la que se va a poner la pieza
     */
    public void ponPieza(Pieza figura, Posicion pos) {
        tablero[pos.getFila()][pos.getColumna()] = figura;
    }

    /**
     * Quita una pieza del tablero, mediante fila y columna
     *
     * @param fila Fila de la casilla
     * @param columna Columna de la casilla
     */
    public void quitaPieza(int fila, int columna) {
        tablero[fila][columna] = null;
    }

    /**
     * * Quita una pieza del tablero, mediante una posicion
     *
     * @param pos Posicion en el tablero
     */
    public void quitaPieza(Posicion pos) {
        tablero[pos.getFila()][pos.getColumna()] = null;
    }

    /**
     * Devuelve una pieza del tablero, mediante fila y columna
     *
     * @param fila Fila de la posicion
     * @param columna Columna de la posicion
     * @return Devuelve la pieza de la fila y columna
     */
    public Pieza devuelvePieza(int fila, int columna) {
        return tablero[fila][columna];
    }

    /**
     * Devuelve una pieza del tablero, mediante una posicion
     *
     * @param pos Posicion en el tablero
     * @return devuelve la pieza de la posicion del tablero
     */
    public Pieza devuelvePieza(Posicion pos) {
        return tablero[pos.getFila()][pos.getColumna()];
    }

    /**
     * Mueve pieza del tablero
     *
     * @param mov Movimiento a realizar
     */
    public void moverPieza(Movimiento mov) {
        tablero[mov.posFinal.getFila()][mov.posFinal.getColumna()] = tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()];
        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = null;
        
    }

}
