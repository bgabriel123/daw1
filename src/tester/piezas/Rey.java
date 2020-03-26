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
public class Rey extends Pieza {

    /**
     * Construye un rey
     * @param color Color del rey
     */
    public Rey(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2654";
        } else {
            nombre = "\u265A";
        }

    }

    /**
     * Comprueba si el movimiento del rey es valido
     * @param movimiento Movimiento a comprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return Math.abs(movimiento.getPosInicial().getFila()-movimiento.getPosFinal().getFila())<2 && Math.abs(movimiento.getPosInicial().getColumna()-movimiento.getPosFinal().getColumna())<2 ;

    }

}
