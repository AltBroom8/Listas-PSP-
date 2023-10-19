// La clase Empleado representa a un empleado de la empresa
package Empresa;

import java.util.GregorianCalendar;

public class Empleado {

    private String nombre;
    private int numero;
    private GregorianCalendar fechaAlta;
    private double sueldo;
    private double sueldoMaximo;

    // Constructor de la clase Empleado
    public Empleado(String nombre, int numero, GregorianCalendar fechaAlta, double sueldo, double sueldoMaximo) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.sueldo = sueldo;
        this.sueldoMaximo = sueldoMaximo;
    }

    // Método para obtener el número del empleado
    public int getNumero() {
        return numero;
    }

    // Método para representar el objeto Empleado en forma de cadena
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", sueldo=" + sueldo +
                ", sueldoMaximo=" + sueldoMaximo +
                '}';
    }

    // Método para obtener el nombre del empleado
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del empleado
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para establecer el número del empleado
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método para obtener la fecha de alta del empleado
    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    // Método para establecer la fecha de alta del empleado
    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    // Método para obtener el sueldo del empleado
    public double getSueldo() {
        return sueldo;
    }

    // Método para establecer el sueldo del empleado
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // Método para obtener el sueldo máximo del empleado
    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    // Método para establecer el sueldo máximo del empleado
    public void setSueldoMaximo(double sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }
}

