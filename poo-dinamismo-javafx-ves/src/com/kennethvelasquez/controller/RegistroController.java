/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.view.RegistroView;
import java.util.ArrayList;
import com.kennethvelasquez.model.Persona;
import com.kennethvelasquez.model.Estudiante;
import com.kennethvelasquez.model.Maestro;
import javafx.collections.FXCollections;

public class RegistroController {
    private final RegistroView registroView;
    private ArrayList <Persona> listaPersonas;
    
    public RegistroController ( RegistroView registroView ){
        this.registroView = registroView;
        cargarDatos();
        construirComboBox();
        construirAcciones();
    }
    public void cargarDatos(){
        Estudiante objetoEstudiante = new Estudiante();
        Maestro objetoMaestro = new Maestro();
        
        listaPersonas = new ArrayList<>();
        
        listaPersonas.add(objetoEstudiante);
        listaPersonas.add(objetoMaestro);
        
    }
    public void construirComboBox(){
        this.registroView.getCmbTipoPersona().setItems(
             FXCollections.observableArrayList( listaPersonas )
        );
    }
    public void construirAcciones(){
        
    }
    
}
