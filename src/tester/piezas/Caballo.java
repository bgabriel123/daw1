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
public class Caballo extends Pieza {

    /**
     * Construye un caballo
     * @param color Color del caballo
     */
    public Caballo(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2658";
        } else {
            nombre = "\u265E";
        }

    }

    /**
     * Comprueba si el movimiento del caballo es valido
     * @param movimiento Movimiento a comprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return (movimiento.saltoHorizontal()) || (movimiento.saltoVertical());

    }
}
