/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;

public class VistaPrincipalView {
    //ATRIBUTOS
    private static VistaPrincipalView instanciaVistaPrincipalView;
    private Pane instanciaPanel;
    private VBox cajaVertical;
    private TabPane seccionTabs;
    private Tab tabRegistro;
    private Tab tabResumen;
    
    //CONSTRUCTORES
    private VistaPrincipalView (){
        construirVista();
    }
    
    public void construirVista(){
        instanciaPanel = new Pane();
        
        cajaVertical = new VBox(15);
        // CONTENEDOR DE PESTAÑAS
        seccionTabs = new TabPane();
        //PESTAÑAS
        tabRegistro = new Tab("Registro");
        tabRegistro.setClosable(false);
        tabResumen = new Tab("Resumen");
        tabResumen.setClosable(false);
        
        seccionTabs.getTabs().addAll( tabRegistro, tabResumen );
        cajaVertical.getChildren().add(seccionTabs);
        instanciaPanel.getChildren().add(cajaVertical);
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public TabPane getSeccionTabs() {
        return seccionTabs;
    }

    public void setSeccionTabs(TabPane seccionTabs) {
        this.seccionTabs = seccionTabs;
    }

    public Tab getTabRegistro() {
        return tabRegistro;
    }

    public void setTabRegistro(Tab tabRegistro) {
        this.tabRegistro = tabRegistro;
    }

    public Tab getTabResumen() {
        return tabResumen;
    }

    public void setTabResumen(Tab tabResumen) {
        this.tabResumen = tabResumen;
    }
    
    

    public static VistaPrincipalView getInstanciaVistaPrincipalView() {
        if( instanciaVistaPrincipalView == null )
            instanciaVistaPrincipalView = new VistaPrincipalView();
        return instanciaVistaPrincipalView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }
}
