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
public class Reina extends Pieza {

    /**
     * Construye una reina
     * @param color Color de la reina
     */
    public Reina(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2655";
        } else {
            nombre = "\u265B";
        }

    }

    /**
     * Comprueba si el movimiento de la reina es valido
     * @param movimiento Movimiento a comprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si el movimiento no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return (movimiento.esDiagonal()) || (movimiento.esHorizontal()) || (movimiento.esVertical());

    }

}
