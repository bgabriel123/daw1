/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.piezas;

import tester.Movimiento;
import tester.Pieza;

/**
 *
 * @author botxxxga
 */
public class Alfil extends Pieza {

    /**
     * Construye un Alfil
     *
     * @param color Color del alfil
     */
    public Alfil(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2657";
        } else {
            nombre = "\u265D";
        }
    }

    /**
     * Comprueba si el movimiento del alfil es valido
     *
     * @param movimiento Movimiento a coomprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si el
     * movimiento no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.esDiagonal();

    }

}
