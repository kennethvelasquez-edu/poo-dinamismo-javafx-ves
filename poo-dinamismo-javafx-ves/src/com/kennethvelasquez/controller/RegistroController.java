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
import com.kennethvelasquez.view.ResumenView;
import javafx.collections.FXCollections;
import javax.swing.JOptionPane;

public class RegistroController {
    private final RegistroView registroView;
    private ArrayList <Persona> listaPersonas;
    private static ArrayList <Persona> listaRegistroPersonas;
    
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
        
        listaRegistroPersonas = new ArrayList<>();
        
    }
    public void construirComboBox(){
        this.registroView.getCmbTipoPersona().setItems(
             FXCollections.observableArrayList( listaPersonas )
        );
    }
    public void construirAcciones(){
        this.registroView.getCmbTipoPersona().setOnAction(
           (evento ) ->{
               validarCampos(this.registroView.getCmbTipoPersona().getValue());
           }
        );
        
        this.registroView.getBtnGuardar().setOnAction(
           (evento ) ->{
               guardarPersona();
           }
        );
        
        this.registroView.getBtnLimpiar().setOnAction(
            (evento) -> {
                limpiarCampos();
                mostrarCampos();
            }
        );
    }
    
    public void limpiarCampos() {
        this.registroView.getTxtNombres().clear();
        this.registroView.getTxtApellidos().clear();
        this.registroView.getTxtCurso().clear();
        this.registroView.getTxtNumeroCarne().clear();
        this.registroView.getTxtGradoEstudiante().clear();
        this.registroView.getTxtGradoMaestro().clear();
        this.registroView.getRbAprabado().setSelected(false);
        this.registroView.getCbActivo().setSelected(false);
        this.registroView.getCmbTipoPersona().getSelectionModel().select(null);
    }
    
    public void mostrarCampos() {
        //Mostramos los campos de estudiante
        this.registroView.getLblAprobado().setVisible(true);
        this.registroView.getLblNumeroCarne().setVisible(true);
        this.registroView.getLblGradoEstudiante().setVisible(true);
        //TextField
        this.registroView.getTxtNumeroCarne().setVisible(true);
        this.registroView.getTxtGradoEstudiante().setVisible(true);
        //RadioButton
        this.registroView.getRbAprabado().setVisible(true);

        //Mostramos los campos de maestros
        this.registroView.getLblActivo().setVisible(true);
        this.registroView.getLblCurso().setVisible(true);
        this.registroView.getLblGradoMaestro().setVisible(true);
        //TextField
        this.registroView.getTxtCurso().setVisible(true);
        this.registroView.getTxtGradoMaestro().setVisible(true);
        //RadioButton
        this.registroView.getRbAprabado().setVisible(true);
    }
    
    public void guardarPersona(){
        if( this.registroView.getCmbTipoPersona().getValue() == null ){
            JOptionPane.showMessageDialog(null, "TIENES QUE ELEGIR EL OBJETO A REGISTRAR");
            return;
        }
        if( this.registroView.getCmbTipoPersona().getValue() instanceof Estudiante ){
            Estudiante nuevoEstudiante = new Estudiante();
            nuevoEstudiante.setNombres( this.registroView.getTxtNombres().getText() );
            nuevoEstudiante.setApellidos( this.registroView.getTxtApellidos().getText() );
            nuevoEstudiante.setAprobado( this.registroView.getRbAprabado().isSelected() );
            nuevoEstudiante.setNumeroCarne( Integer.parseInt( this.registroView.getTxtNumeroCarne().getText() ) );
            nuevoEstudiante.setGrado(this.registroView.getTxtGradoEstudiante().getText());
            listaRegistroPersonas.add(nuevoEstudiante);
        }else{
             Maestro nuevoMaestro = new Maestro();
            nuevoMaestro.setNombres( this.registroView.getTxtNombres().getText() );
            nuevoMaestro.setApellidos( this.registroView.getTxtApellidos().getText() );
            nuevoMaestro.setActivo(this.registroView.getCbActivo().isSelected() );
            nuevoMaestro.setCurso(this.registroView.getTxtCurso().getText()  );
            nuevoMaestro.setGrado(this.registroView.getTxtGradoEstudiante().getText());
            listaRegistroPersonas.add(nuevoMaestro);
        }
        //Cada que agrego a la lista, independientemente del objeto actualizare la lista en el resument
        new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();
        
    }
    
    public void validarCampos(Persona objetoPersonaSeleccionado ){
        if (objetoPersonaSeleccionado == null) {
            return;
        }
        String claseSeleccionada = objetoPersonaSeleccionado.toString();
        if( claseSeleccionada.equals("Estudiante")  ){
            //LLAMANDO A LOS LABEL y ocultandolo
            this.registroView.getLblGradoMaestro().setVisible(false);
            this.registroView.getLblCurso().setVisible(false);
            this.registroView.getLblActivo().setVisible(false);
            //TEXTFIELD
            this.registroView.getTxtGradoMaestro().setVisible(false);
            this.registroView.getTxtCurso().setVisible(false);
            //CHECBOX
            this.registroView.getCbActivo().setVisible(false);
            
            //Mostramos los campos de estudiante
            this.registroView.getLblAprobado().setVisible(true);
            this.registroView.getLblNumeroCarne().setVisible(true);
            this.registroView.getLblGradoEstudiante().setVisible(true);
            //TextField
            this.registroView.getTxtNumeroCarne().setVisible(true);
            this.registroView.getTxtGradoEstudiante().setVisible(true);
            //RadioButton
            this.registroView.getRbAprabado().setVisible(true);
        }else{
            //LLAMANDO A LOS LABEL y ocultandolo
            this.registroView.getLblGradoEstudiante().setVisible(false);
            this.registroView.getLblNumeroCarne().setVisible(false);
            this.registroView.getLblAprobado().setVisible(false);
            //TEXTFIELD
            this.registroView.getTxtGradoEstudiante().setVisible(false);
            this.registroView.getTxtNumeroCarne().setVisible(false);
            //CHECBOX
            this.registroView.getRbAprabado().setVisible(false);
            
            //Mostramos los campos de maestros
            this.registroView.getLblActivo().setVisible(true);
            this.registroView.getLblCurso().setVisible(true);
            this.registroView.getLblGradoMaestro().setVisible(true);
            //TextField
            this.registroView.getTxtCurso().setVisible(true);
            this.registroView.getTxtGradoMaestro().setVisible(true);
            //RadioButton
            this.registroView.getCbActivo().setVisible(true);
        }
    }

    public static ArrayList<Persona> getListaRegistroPersonas() {
        return listaRegistroPersonas;
    }
    
}
