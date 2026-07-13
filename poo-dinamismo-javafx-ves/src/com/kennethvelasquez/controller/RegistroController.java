/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.exceptions.ExcepcionesPersonalizadas;
import com.kennethvelasquez.view.RegistroView;
import java.util.ArrayList;
import com.kennethvelasquez.model.Persona;
import com.kennethvelasquez.model.Estudiante;
import com.kennethvelasquez.model.Maestro;
import com.kennethvelasquez.view.ResumenView;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
               limpiarCampos();
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
        this.registroView.getRbAprobado().setSelected(false);
        this.registroView.getCbActivo().setSelected(false);
        this.registroView.getCmbTipoPersona().getSelectionModel().select(null);
    }
    
    public void mostrarCampos() {
        boolean seleccion = true;
        
         //CAMPOS DE ESTUDIANTE
        cambiarVisibilidadCampos(this.registroView.getLblGradoEstudiante(),
                                 this.registroView.getTxtGradoEstudiante(),
                                 seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblNumeroCarne(),
                                 this.registroView.getTxtNumeroCarne(),
                                 seleccion);
        //Agrego ahora el campo de activo
        cambiarVisibilidadCampos(this.registroView.getLblActivo(), 
                                this.registroView.getCbActivo(), 
                                seleccion);
        
        //CAMPOS DE MAESTRO
        cambiarVisibilidadCampos(this.registroView.getLblCurso(),  
                                 this.registroView.getTxtCurso(), 
                                 seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblGradoMaestro(),
                                 this.registroView.getTxtGradoMaestro(),
                                 seleccion);
        //Agrego ahora el campo de aprobado
        cambiarVisibilidadCampos(this.registroView.getLblAprobado(), 
                                 this.registroView.getRbAprobado(), 
                                 seleccion);
    }
    
    public void guardarPersona(){
        if( this.registroView.getCmbTipoPersona().getValue() == null ){
            JOptionPane.showMessageDialog(null, "TIENES QUE ELEGIR EL OBJETO A REGISTRAR");
            return;
        }
        
        if( this.registroView.getCmbTipoPersona().getValue() instanceof Estudiante ){
            try {
                ExcepcionesPersonalizadas objetoExcepciones = new ExcepcionesPersonalizadas();
                Estudiante nuevoEstudiante = new Estudiante();
                
                //CARNE
                objetoExcepciones.validarCampoNumericoEntero( this.registroView.getTxtNumeroCarne().getText() );
                //NOMBRES Y APELLIDOS
                objetoExcepciones.validarLongitudTexto(this.registroView.getTxtNombres().getText(), 15);
                objetoExcepciones.validarLongitudTexto(this.registroView.getTxtApellidos().getText(), 5);
                
                nuevoEstudiante.setNombres( this.registroView.getTxtNombres().getText() );
                nuevoEstudiante.setApellidos( this.registroView.getTxtApellidos().getText() );
                nuevoEstudiante.setAprobado(   this.registroView.getRbAprobado().isSelected() );
                nuevoEstudiante.setNumeroCarne( Integer.parseInt(this.registroView.getTxtNumeroCarne().getText())  );
                nuevoEstudiante.setGrado(    this.registroView.getTxtGradoEstudiante().getText()  );
                
                listaRegistroPersonas.add(nuevoEstudiante);
                
                JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL ESTUDIANTE CON EXITO");
            } catch (ExcepcionesPersonalizadas miExcepcion) {
                JOptionPane.showMessageDialog(null, miExcepcion.getMessage());
                miExcepcion . printStackTrace();
            }
            /* Linea del error logico en el registro
               es lo que mencionaba, que cada que guardaba tenia que instanciar la clase
             */
            //new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();
        }else{
            try {
                ExcepcionesPersonalizadas objetoMisExcepciones = new ExcepcionesPersonalizadas();
                
                Maestro nuevoMaestro = new Maestro();
                
                //Nombres y apellidos
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtNombres().getText(), 50);
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtApellidos().getText(), 50);
                //Curso
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtCurso().getText(), 30);
                
                nuevoMaestro.setNombres(this.registroView.getTxtNombres().getText());
                nuevoMaestro.setApellidos(this.registroView.getTxtApellidos().getText());

                nuevoMaestro.setActivo(this.registroView.getCbActivo().isSelected());
                nuevoMaestro.setGrado(this.registroView.getTxtGradoMaestro().getText());
                nuevoMaestro.setCurso(this.registroView.getTxtCurso().getText());

                listaRegistroPersonas.add(nuevoMaestro);
                
                JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL MAESTRO CON EXITO");
            } catch (ExcepcionesPersonalizadas miExcepcion) {
               JOptionPane.showMessageDialog(null, miExcepcion . getMessage());
               miExcepcion.printStackTrace();
            }
        }
        //Cada que agrego a la lista, independientemente del objeto actualizare la lista en el resument
        new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();
        
    }
    
    public void validarCampos(Persona objetoPersonaSeleccionado ){
        if (objetoPersonaSeleccionado == null) {
            return;
        }
        String claseSeleccionada = objetoPersonaSeleccionado.toString();
        
        boolean seleccion = claseSeleccionada.equals("Estudiante"); 
        
        //CAMPOS DE ESTUDIANTE
        cambiarVisibilidadCampos(this.registroView.getLblGradoEstudiante(),
                                 this.registroView.getTxtGradoEstudiante(),
                                 seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblNumeroCarne(),
                                 this.registroView.getTxtNumeroCarne(),
                                 seleccion);
        //Agrego ahora el campo de aprobado
        cambiarVisibilidadCampos(this.registroView.getLblAprobado(), 
                                this.registroView.getRbAprobado(), 
                                seleccion);
        
        //CAMPOS DE MAESTRO
        cambiarVisibilidadCampos(this.registroView.getLblCurso(),  
                                 this.registroView.getTxtCurso(), 
                                 !seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblGradoMaestro(),
                                 this.registroView.getTxtGradoMaestro(),
                                 !seleccion);
        //Agrego ahora el campo de activo
        cambiarVisibilidadCampos(this.registroView.getLblActivo(), 
                                this.registroView.getCbActivo(), 
                                !seleccion);
        
    }
    /**
     * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
     * @param etiqueta Etiqueta que nombra al campo
     * @param campoTexto Campo de tipo TextField referido por la etiqueta
     * @param visible Valor true para visualizarse y false para ocultarse
     */
    public void cambiarVisibilidadCampos(Label etiqueta, TextField campoTexto, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        campoTexto.setVisible(visible);
        campoTexto.setManaged(visible);
    }
    
    /**
    * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
    * @param etiqueta Etiqueta que nombra al campo
    * @param cajaSeleccion Campo de tipo CheckBox referido por la etiqueta
    * @param visible Valor true para visualizarse y false para ocultarse
    */ 
    public void cambiarVisibilidadCampos(Label etiqueta, CheckBox cajaSeleccion, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        cajaSeleccion.setVisible(visible);
        cajaSeleccion.setManaged(visible);
    }
    
    /**
     * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
     * @param etiqueta Etiqueta que nombra al campo
     * @param botonSeleccion Campo de tipo RadioButton referido por la etiqueta
     * @param visible Valor true para visualizarse y false para ocultarse
     */
    public void cambiarVisibilidadCampos(Label etiqueta, RadioButton botonSeleccion, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        botonSeleccion.setVisible(visible);
        botonSeleccion.setManaged(visible);
    }
    
    //Como el atributo es static, el metodo tambien debe serlo
    public static ArrayList<Persona> getListaRegistroPersonas() {
        return listaRegistroPersonas;
    }
    
}
