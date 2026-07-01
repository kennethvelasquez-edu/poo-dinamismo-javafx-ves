/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethv.model;

/**
 *
 * @author STEPHRYS
 */
public abstract class Persona {
    //ATRIBUTOS
    protected String nombres;
    protected String apellidos;
    
    //CONSTRUCTORES
    public Persona(){
        
        
    }
    public Persona(String nombres, String apellidos){
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    //METODOS
    //Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    //Personalizados
    public abstract String presentacionPersona();
    
    @Override
    public abstract String toString();

}
