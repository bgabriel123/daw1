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
public class Jefe_Proyecto extends Trabajador{
    protected int personas_cargo;

    public Jefe_Proyecto(String nombre, String nif, String departamento, Fecha fecha_alta,int personas_cargo) {
        super(nombre, nif,(Math.random()*500)+1500, departamento, fecha_alta);
        this.personas_cargo=personas_cargo;
    }

    @Override
    public double calcularSalarioReal() {
        return sueldo+(sueldo*(personas_cargo/100));
    }

    @Override
    public void mostrarTrabajador() {
        System.out.println( nombre + "[" + nif + "; " + sueldo + "; " + departamento + "; " + fecha_alta.mostrarFecha() + ";" + personas_cargo+ "]");
    }
    
}
