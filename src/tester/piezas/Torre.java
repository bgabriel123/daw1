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
public class Torre extends Pieza {

    /**
     * Construye una torre
     * @param color Color de la torre
     */
    public Torre(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2656";
        } else {
            nombre = "\u265C";
        }

    }

    /**
     * Comprueba si el movimiento de la torre es valido
     * @param movimiento Movimiento a comprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si el movimiento no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.esVertical() || movimiento.esHorizontal();

    }

}
