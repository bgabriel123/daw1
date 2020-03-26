/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andru
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    static void ejecucion(String op, Empresa empresa) throws IOException {
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        switch (op) {
            case "LISTAR TRABAJADORES":
                System.out.println("------   LISTAR TRABAJADORES  ------");
                empresa.listadoTrabajadores();
                System.out.println("------------------------------------");
                System.out.println("");
                break;
            case "ANYADIR TRABAJADOR":
                System.out.println("------   ANYADIR TRABAJADOR  ------");
                boolean salida=false;
                for (int i = 0; i < empresa.trabajadores.length && salida==false; i++) {
                    if (empresa.trabajadores[i] == null) {
                        empresa.trabajadores[i] = empresa.anyadirTrabajador();
                        salida=true;
                    }
                }
                System.out.println((salida==false)?"EMPRESA LLENA DE TRABAJADORES":"TRABJADOR AÑADIDO");
                System.out.println("------------------------------------");
                System.out.println("");
                break;
            case "CONSULTAR TRABAJADORES":
                System.out.println("------   CONSULTAR TRABAJADORES  ------");
                System.out.print("Departamanto a filtrar: ");
                String dep = scb.readLine().toUpperCase();
                empresa.consultaTrabajadores(dep);
                System.out.println("---------------------------------------");
                System.out.println("");
                break;
            case "ACTUALIZAR SALARIO":
                System.out.println("------   ACTUALIZAR SALARIO  ------");
                System.out.print("NIF de la persona a actualizar el salario: ");
                String nif = scb.readLine().toUpperCase();
                empresa.acutalizarSalarioBase(nif);
                System.out.println("---------------------------------------");
                System.out.println("");
                break;
            case "ACTUALIZAR PERSONAS":
                System.out.println("------     ACTUALIZAR PERSONAS  JEFES DE PROYECTO   ------");
                System.out.print("NOMBRE de la persona: ");
                String nombre = scb.readLine().toUpperCase();
                System.out.println((empresa.actualizarPersonas(nombre) == true) ? "PERSONAS ACTUALIZADAS" : "NO SE HA ENCONTRADO A " + nombre);
                System.out.println("-----------------------------------------");
                System.out.println("");
                break;
            case "ELIMINAR TRABAJADOR":
                System.out.println("------     ELIMINAR TRABAJADOR   ------");
                empresa.eliminarTrabajador();
                System.out.println("---------------------------------------");
                System.out.println("");
                break;
            case "MOSTRAR SALARIO REAL DE TRABAJADORES":
                System.out.println("------     MOSTRAR SALARIO REAL DE TRABAJADORES   ------");
                empresa.mostrarSalariosPorDepartamento();
                System.out.println("---------------------------------------");
                System.out.println("");
                break;
            case "MOSTRAR EMPLEADOS ORDENADOS":
                System.out.println("------     MOSTRAR EMPLEADOS ORDENADOS   ------");
                empresa.mostrarEmpleadosOrdenados();
                System.out.println("---------------------------------------");
                System.out.println("");
                break;
        }
    }

    static boolean comprobarOpcion(String op, String[] arr_op) {
        boolean salida = false;
        for (int i = 0; i < arr_op.length; i++) {
            if (op.equals(arr_op[i])) {
                salida = true;
            }
        }
        return salida;
    }

    public static void main(String[] args) throws IOException {
        Empresa everis = new Empresa();
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        String[] menu_op = {"LISTAR TRABAJADORES", "ANYADIR TRABAJADOR", "CONSULTAR TRABAJADORES", "ACTUALIZAR SALARIO", "ACTUALIZAR PERSONAS", "ELIMINAR TRABAJADOR", "MOSTRAR SALARIO REAL DE TRABAJADORES", "MOSTRAR EMPLEADOS ORDENADOS", "SALIR"};
        String op;
        do {

            System.out.println("------------------- M  E  N  U -------------------");
            for (int i = 0; i < menu_op.length; i++) {
                System.out.println((i + 1) + ". " + menu_op[i]);
            }
            System.out.println("--------------------------------------------------");

            do {
                System.out.print("Ejecutar: ");
                op = scb.readLine().toUpperCase();
                if (!comprobarOpcion(op, menu_op)) {
                    System.out.println("ERROR | VUELVE A INTRODUCIR");
                }
            } while (!comprobarOpcion(op, menu_op));
            System.out.println("");
            ejecucion(op, everis);
        } while (!op.equals("SALIR"));
    }

}
