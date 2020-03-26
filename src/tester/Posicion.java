/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author botxxxga
 */
public class Posicion {

    private int fila;
    private int columna;

    /**
     * Construye una posicion Bidimensional
     * @param columna Columna de la Posicion
     * @param fila Fila de la posicion
     */
    public Posicion(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Devuelve al atributo fila de la posicion
     * @return Devuelve al atributo fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Asigna nuevo valor al atributo fila de la posicion
     * @param fila Nuevo valor de la fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Devuelve el atributo columna de la posicion
     * @return Devuelve el atributo columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Asigna nuevo valor al atributo columna de la posicion
     * @param columna Nuevo valor de la columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

}
