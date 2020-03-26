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
public class Peon extends Pieza {

    /**
     * Construye un peon
     *
     * @param color Color del peon
     */
    public Peon(String color) {
        super(color);
        if (this.color.equalsIgnoreCase("blanco")) {
            nombre = "\u2659";
        } else {
            nombre = "\u265F";
        }

    }

    /**
     * Comprueba si el movimiento del peon es valido
     *
     * @param movimiento Movimiento a comprobar
     * @return devuelve true si el movimiento es correcto, devuelve false si el
     * movimiento no es correcto
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        if ((movimiento.getPosInicial().getFila() == 6 || movimiento.getPosInicial().getFila() == 1) && Math.abs(movimiento.getPosInicial().getFila() - movimiento.getPosFinal().getFila()) < 3 && movimiento.esVertical()) {
            return true;
            
}else if (Math.abs(movimiento.getPosInicial().getFila() - movimiento.getPosFinal().getFila()) < 2 && movimiento.esVertical()){
    return true;
} 
 {
    return false;
}

    }

}
