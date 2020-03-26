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
public class Fecha {
    protected int dia;
    protected int mes;
    protected int anyo;

    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    public String mostrarFecha(){
        return dia+"/"+mes+"/"+anyo;
    }
    
    
    
}
