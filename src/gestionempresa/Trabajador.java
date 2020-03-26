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
public abstract class Trabajador {
    protected String nombre;
    protected String nif;
    protected String departamento;
    protected double sueldo;
    protected Fecha fecha_alta;

    public Trabajador(String nombre, String nif,double sueldo, String departamento, Fecha fecha_alta) {
        this.nombre = nombre;
        this.nif = nif;
        this.sueldo=sueldo;
        this.departamento = departamento;
        this.fecha_alta = fecha_alta;
    }
    
    public abstract double calcularSalarioReal();
    
    public abstract void mostrarTrabajador();
    
    
}
