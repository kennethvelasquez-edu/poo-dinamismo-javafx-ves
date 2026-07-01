
package com.kennethvelasquez.controller;

import com.kennethvelasquez.view.RegistroView;
import com.kennethvelasquez.view.VistaPrincipalView;

public class VistaPrincipalController {
    private final VistaPrincipalView vistaPrincipalView;
    
    public VistaPrincipalController( VistaPrincipalView vistaPrincipal ){
        this.vistaPrincipalView = vistaPrincipal;
        construirControladores();
        construirAcciones();
    }
    
    public void construirControladores(){
        new RegistroController( RegistroView.getInstanciaRegistroView() );
    }
    
    public void construirAcciones(){
        this.vistaPrincipalView.getTabRegistro().setContent(
            RegistroView.getInstanciaRegistroView().getInstanciaPanel()
        );
    }
    
}
