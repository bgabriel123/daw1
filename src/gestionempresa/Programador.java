/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempresa;

/**
 *
 * @author Andru
 */
public class Programador extends Trabajador {

    protected String[] lenguajes;
    protected boolean exp_POO;

    public Programador(String nombre, String nif, String departamento, Fecha fecha_alta, String[] lenguajes, boolean exp_POO) {
        super(nombre, nif, (Math.random() * 500) + 1000, departamento, fecha_alta);
        this.lenguajes = lenguajes;
        this.exp_POO = exp_POO;
    }

    @Override
    public double calcularSalarioReal() {
        return (exp_POO == true) ? sueldo + (sueldo * 0.20) : sueldo;

    }

    void mostrarLenguajes() {
        for (int i = 0; i < lenguajes.length; i++) {
            if (lenguajes[i] != null) {
                System.out.print(lenguajes[i] + " | ");
            }

        }

    }

    String mostrarExp_POO() {
        return (exp_POO == true) ? "SI" : "NO";
    }

    @Override
    public void mostrarTrabajador() {
        System.out.print(nombre + "[" + nif + "; " + sueldo + "; " + departamento + "; " + fecha_alta.mostrarFecha() + "; ");
        mostrarLenguajes();
        System.out.println("; " + mostrarExp_POO() + "]");
    }

}
