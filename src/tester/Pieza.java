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
public abstract class Pieza {

    protected String color;
    protected String nombre;

    /**
     * Contruye una pieza
     *
     * @param color Color de la pieza. Solo puede ser negro o blanco
     */
    public Pieza(String color) {
        if (color.equalsIgnoreCase("negro") || color.equalsIgnoreCase("blanco")) {
            this.color = color;
        }
    }

    /**
     * Devulve el atributo color de la pieza
     *
     * @return Devuelve el atributo color de la pieza
     */
    public String getColor() {
        return color;
    }

    /**
     * Devuelve si el movimiento es valido. Es diferente por cada figura
     *
     * @param movimiento Movimiento ha realizar
     * @return Devuelve true si el movimiento es valido, devuelve false si no es
     * valido
     */
    public abstract boolean validoMovimiento(Movimiento movimiento);

}
