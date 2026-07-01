/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import com.kennethv.model.Persona;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;


public class RegistroView {
    private static RegistroView instanciaRegistroView;
    private Pane instanciaPanel;
    private ComboBox <Persona> cmbTipoPersona;
    private VBox cajaVertical;
    private Label lblTipoPersona;
    private GridPane formulario;
    private TableView <Persona> tblPersona;
    private TableColumn <Persona,String> colNombres;
    
    public RegistroView(){
        construirVista();
    }
    
    public void construirVista(){
        instanciaPanel = new Pane();
        
        cajaVertical = new VBox(10);
        cmbTipoPersona = new ComboBox<>();
        lblTipoPersona = new Label("Seleccione el Objeto a crear");
        
        tblPersona = new TableView<>();
        
        colNombres = new TableColumn<>();
        
        
        formulario = new GridPane(15,10);
        
        cajaVertical.getChildren().addAll(lblTipoPersona, cmbTipoPersona);
        
        instanciaPanel.getChildren().add(cajaVertical);
    }

    public Label getLblTipoPersona() {
        return lblTipoPersona;
    }

    public void setLblTipoPersona(Label lblTipoPersona) {
        this.lblTipoPersona = lblTipoPersona;
    }

    public GridPane getFormulario() {
        return formulario;
    }

    public void setFormulario(GridPane formulario) {
        this.formulario = formulario;
    }

    public ComboBox<Persona> getCmbTipoPersona() {
        return cmbTipoPersona;
    }

    public void setCmbTipoPersona(ComboBox<Persona> cmbTipoPersona) {
        this.cmbTipoPersona = cmbTipoPersona;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public TableView<Persona> getTblPersona() {
        return tblPersona;
    }

    public void setTblPersona(TableView<Persona> tblPersona) {
        this.tblPersona = tblPersona;
    }

    public TableColumn<Persona, String> getColNombres() {
        return colNombres;
    }

    public void setColNombres(TableColumn<Persona, String> colNombres) {
        this.colNombres = colNombres;
    }
    

    
    
    public static RegistroView getInstanciaRegistroView(){
        if( instanciaRegistroView == null )
            instanciaRegistroView = new RegistroView();
        return instanciaRegistroView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }
}
