/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andru
 */
public class Empresa {

    protected Trabajador[] trabajadores;

    public Empresa() {
        trabajadores = new Trabajador[10];
        for (int i = 0; i < trabajadores.length; i++) {

            if (i < 5) {
                String[] lenguajes = {"HTML", "CSS", "JAVA"};
                trabajadores[i] = new Programador("TESTER", "12345678Z", "IT", new Fecha((int) ((Math.random() * 30) + 1), (int) ((Math.random() * 12) + 1), (int) ((Math.random() * 100) + 1950)), lenguajes, true);
            } else {
                trabajadores[i] = new Jefe_Proyecto("TESTER_JEFE", "12345678Y", "AN", new Fecha((int) ((Math.random() * 30) + 1), (int) ((Math.random() * 12) + 1), (int) ((Math.random() * 100) + 1950)), 50);
            }
        }
    }

    public Empresa(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void listadoTrabajadores() {
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null) {
                trabajadores[i].mostrarTrabajador();
            }

        }
    }

    public Trabajador anyadirTrabajador() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        String op;
        Trabajador nuevo_trabajador = null;
        do {
            System.out.println("¿PROGRAMADOR O JEFE DE PROYECTO?");
            op = scb.readLine().toUpperCase();
            if (op.equals("PROGRAMADOR") || op.equals("JEFE DE PROYECTO")) {
                System.out.print("NOMBRE: ");
                String nombre = scb.readLine().toUpperCase();
                String nif;
                do {
                    System.out.print("NIF: ");
                    nif = scb.readLine().toUpperCase();
                    if (!(nif.length() == 9)) {
                        System.out.println("TAMAÑO INCORRECTO | VUELVE A INTRODUCIR");
                    }
                } while (!(nif.length() == 9));
                System.out.print("DEPARTAMENTO: ");
                String departamento = scb.readLine().toUpperCase();
                if (op.equals("PROGRAMADOR")) {
                    String choose;
                    boolean c_POO;
                    do {
                        System.out.print("¿Tiene concomientos de POO?: ");
                        choose = scb.readLine().toUpperCase();
                        if (!choose.equals("SI") && !choose.equals("NO")) {
                            System.out.println("ERROR | VUELVE A INTRODUCIR");
                        }
                        c_POO = (choose.equals("SI"));
                    } while (!choose.equals("SI") && !choose.equals("NO"));
                    String[] lenguajes = new String[5];
                    System.out.println("Lenguajes de Programación (MAX. 5) [** para terminar] ");
                    String lenguaje = "0";
                    for (int i = 0; i < lenguajes.length && !lenguaje.equals("**"); i++) {
                        lenguaje = scb.readLine().toUpperCase();
                        if (!lenguaje.equals("**")) {
                            lenguajes[i] = lenguaje;
                        }

                    }
                    for (int i = 0; i < trabajadores.length; i++) {
                        if (trabajadores[i] == null) {
                            nuevo_trabajador = new Programador(nombre, nif, departamento, new Fecha((int) ((Math.random() * 30) + 1), (int) ((Math.random() * 12) + 1), (int) ((Math.random() * 100) + 1950)), lenguajes, c_POO);
                        }
                    }
                } else {
                    System.out.print("¿Cuantas personas dirige?: ");
                    int num_p = sc.nextInt();
                    nuevo_trabajador = new Jefe_Proyecto(nombre + "_JEFE", nif, departamento, new Fecha((int) ((Math.random() * 30) + 1), (int) ((Math.random() * 12) + 1), (int) ((Math.random() * 100) + 1950)), num_p);

                }
            } else {
                System.out.println("ERROR | VUELVE A INTRODUCIR");
            }
        } while (!(op.equals("PROGRAMADOR") || op.equals("JEFE DE PROYECTO")));
        return nuevo_trabajador;
    }

    public void consultaTrabajadores(String dep) {
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null && trabajadores[i].departamento.equals(dep)) {
                trabajadores[i].mostrarTrabajador();
            }
        }
    }

    public void acutalizarSalarioBase(String nif) {
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null && trabajadores[i].nif.equals(nif)) {
                System.out.print("Introduce Nuevo Salario: ");
                double sueldo = sc.nextDouble();
                trabajadores[i].sueldo = sueldo;
                salida = true;
            }
        }
        System.out.println((salida == true) ? "Salario actualizado" : "No se ha encontrado al trabajador con el nif: " + nif);
    }

    public boolean actualizarPersonas(String nombre) {
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null && trabajadores[i].nombre.equals(nombre) && trabajadores[i] instanceof Jefe_Proyecto) {
                System.out.print("Introduce nuevo valor: ");
                int num_p = sc.nextInt();
                Jefe_Proyecto t_mod = (Jefe_Proyecto) trabajadores[i];
                t_mod.personas_cargo = num_p;
                trabajadores[i] = t_mod;
                salida = true;

            }

        }
        return salida;
    }

    public void eliminarTrabajador() throws IOException {
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nombre: ");
        String nombre = scb.readLine().toUpperCase();
        System.out.print("Departamento: ");
        String dep = scb.readLine().toUpperCase();
        boolean salida = false;
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null && trabajadores[i].nombre.equals(nombre) && trabajadores[i].departamento.equals(dep)) {
                trabajadores[i] = null;
                salida = true;
            }
        }
        System.out.println((salida == true) ? "Trabajador " + nombre + " eliminado" : "No se ha encontrado al trabajador");
    }

    public void mostrarSalariosPorDepartamento() throws IOException {
        BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Departamento: ");
        String dep = scb.readLine().toUpperCase();
        double total = 0;
        boolean salida = false;
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] != null && trabajadores[i].departamento.equals(dep)) {
                total += trabajadores[i].calcularSalarioReal();
                System.out.println("------------------------");
                trabajadores[i].mostrarTrabajador();
                System.out.println("SALARIO REAL: " + trabajadores[i].calcularSalarioReal());
                System.out.println("------------------------");
                salida = true;
            }
        }

        System.out.println((salida == true) ? "El salario total del departamento es de: " + total : "No se ha encontrado el departamento " + dep);
    }

    public void mostrarEmpleadosOrdenados() {
        Trabajador[] t_ordenados = trabajadores;
        for (int i = 0; i < t_ordenados.length; i++) {
            for (int j = 0; j < t_ordenados.length; j++) {
                if (t_ordenados[i] != null && t_ordenados[j] != null && t_ordenados[i].sueldo > t_ordenados[j].sueldo) {
                    Trabajador aux = t_ordenados[i];
                    t_ordenados[i] = t_ordenados[j];
                    t_ordenados[j] = aux;
                }
            }

        }
        for (int i = 0; i < t_ordenados.length; i++) {
            if (t_ordenados[i] != null) {
                t_ordenados[i].mostrarTrabajador();
            }

        }
    }
}
