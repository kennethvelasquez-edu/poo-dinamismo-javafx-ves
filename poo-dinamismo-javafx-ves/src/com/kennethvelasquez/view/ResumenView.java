/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import com.kennethvelasquez.model.Persona;

public class ResumenView {
    private static ResumenView instanciaResumenView;
    private Pane instanciaPanel;
    private TableView <Persona> tblPersonas;
    private TableColumn <Persona , String> colNombres;
    private TableColumn <Persona, String> colApellidos;
    private VBox cajaVertical;
    
    private ResumenView(){
        construirVista();
    }
    
    public void construirVista(){
        instanciaPanel = new Pane();
        cajaVertical = new VBox(10);
        
        tblPersonas = new TableView<>();
        
        colNombres = new TableColumn<>("Nombres");
        colApellidos = new TableColumn<>("Apellidos");
        
        tblPersonas.getColumns().add(colNombres);
        tblPersonas.getColumns().add(colApellidos);
        
        cajaVertical.getChildren().add(tblPersonas);
        instanciaPanel.getChildren().add(cajaVertical);
    }

    public static ResumenView getInstanciaResumenView() {
        if( instanciaResumenView == null  )
            instanciaResumenView = new ResumenView();
        return instanciaResumenView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public TableView<Persona> getTblPersonas() {
        return tblPersonas;
    }

    public void setTblPersonas(TableView<Persona> tblPersonas) {
        this.tblPersonas = tblPersonas;
    }

    public TableColumn<Persona, String> getColNombres() {
        return colNombres;
    }

    public void setColNombres(TableColumn<Persona, String> colNombres) {
        this.colNombres = colNombres;
    }

    public TableColumn<Persona, String> getColApellidos() {
        return colApellidos;
    }

    public void setColApellidos(TableColumn<Persona, String> colApellidos) {
        this.colApellidos = colApellidos;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }
    
    
}
