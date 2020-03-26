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
public class Movimiento {

    protected Posicion posInicial;
    protected Posicion posFinal;

    /**
     * Construye un movimiento
     *
     * @param posInicial Posicion Inicial del Movimiento
     * @param posFinal Posicion Final del Movimiento
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;

    }
/**
 * Devuelve posicion inicial
 * @return devuelve posicion inicial
 */
    public Posicion getPosInicial() {
        return posInicial;
    }
/**
 * devuelve posicion final
 * @return devuelve posicion final
 */
    public Posicion getPosFinal() {
        return posFinal;
    }
    
    /**
     * Comprueba si el movimiento es vertical
     *
     * @return devuelve true si el movimiento es vertical, devuelve false si no
     * lo es
     */
    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna();
    }

    /**
     * Comprueba si el movimiento es horizontal
     *
     * @return devuelve true si el movimiento es horizontal, devuelve false si
     * no lo es
     */
    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila();
    }

    /**
     * Comprueba si el movimiento es diagonal
     *
     * @return devuelve true si el movimiento es diagonal, devuelve false si no
     * lo es
     */
    public boolean esDiagonal() {
        return (posInicial.getFila() - posFinal.getFila() == posInicial.getColumna() - posFinal.getColumna()) || (posInicial.getFila() + posFinal.getFila() == posInicial.getColumna() + posFinal.getColumna());

    }

    /**
     * Comprueba si el salto del caballo esta bien realizado verticalmente
     *
     * @return devuelve true si esta bien realizado, devuelve false si no lo
     * esta
     */
    public boolean saltoVertical() {
        return (posFinal.getColumna() == posInicial.getColumna() + 1 || posFinal.getColumna() == posInicial.getColumna() - 1) && (posFinal.getFila() == posInicial.getFila() + 2 || posFinal.getFila() == posInicial.getFila() - 2);
    }

    /**
     * Comprueba si el salto del caballo esta bien realizado horizontalmente
     *
     * @return devuelve true si esta bien realizado, devuelve false si no lo
     * esta
     */
    public boolean saltoHorizontal() {
        return (posFinal.getColumna() == posInicial.getColumna() + 2 || posFinal.getColumna() == posInicial.getColumna() - 2) && (posFinal.getFila() == posInicial.getFila() + 1 || posFinal.getFila() == posInicial.getFila() - 1);
    }

    
}
