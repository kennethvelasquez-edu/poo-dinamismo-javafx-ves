/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.model.Persona;
import com.kennethvelasquez.view.ResumenView;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResumenController {
    private final ResumenView resumenView;
    private ObservableList <Persona> listaObservablePersonas;

    public ResumenController(ResumenView resumenView) {
        this.resumenView = resumenView;
        construirColumnas();
        cargarDatos();
        construirAcciones();
    }
    public void construirColumnas(){
        this.resumenView.getColNombres().setCellValueFactory(
            new PropertyValueFactory<Persona, String>("nombres")
        );
        this.resumenView.getColApellidos().setCellValueFactory( 
            new PropertyValueFactory <Persona, String>("apellidos")
        );
    }
    public void cargarDatos(){
        ArrayList <Persona> listaRegistroPersonas 
                = RegistroController.getListaRegistroPersonas(); //trae la lista registro del registro Controller
        //CONVERTIR lista registro en conjunto de objetos
        listaObservablePersonas = FXCollections.observableArrayList(listaRegistroPersonas );
        
        //Pasar lista observable a la tabla
        this.resumenView.getTblPersonas().setItems( listaObservablePersonas );
    }
    
    public void construirAcciones(){
        
    }
}
