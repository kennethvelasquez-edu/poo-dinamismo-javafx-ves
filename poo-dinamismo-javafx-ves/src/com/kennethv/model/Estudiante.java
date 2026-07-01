/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethv.model;

/**
 *
 * @author STEPHRYS
 */
public class Estudiante extends Persona{
    //ATRIBUTOS
    private String grado;
    private int numeroCarne;
    private boolean esAprobado;
    
    //CONSTRUCTORES
    public Estudiante(){
        super();
    }

    public Estudiante(String grado, int numeroCarne, boolean esAprobado, 
            String nombres, String apellidos) {
        super(nombres, apellidos);
        this.grado = grado;
        this.numeroCarne = numeroCarne;
        this.esAprobado = esAprobado;
    }
    
    //Metodo
    //Getters y Setter
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getNumeroCarne() {
        return numeroCarne;
    }

    public void setNumeroCarne(int numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public boolean isAprobado() {
        return esAprobado;
    }

    public void setAprobado(boolean esAprobado) {
        this.esAprobado = esAprobado;
    }
    
    //Metodos heredados
    @Override
    public String presentacionPersona(){
        return "Mi nombre es "  + this.nombres
                +"\nMi apellido es " + this. apellidos
                +"\nMi grado es " + this.grado
                +"\nMi carne es " + this.numeroCarne
                +"\nMi estado aprobado es " +this.esAprobado;
    }
    
    @Override
    public String toString(){
        return "Estudiante";
    }
    
}
