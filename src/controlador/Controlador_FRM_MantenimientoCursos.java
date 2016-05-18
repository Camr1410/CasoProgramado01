
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoCursos;

public class Controlador_FRM_MantenimientoCursos implements ActionListener {
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Inicio frm_Inicio;
    public MetodosCursos metodosCursos;
    ConexionBD conexion;
    
    public Controlador_FRM_MantenimientoCursos(FRM_Inicio frm_Inicio,FRM_MantenimientoCursos frm_MantenimientoCursos,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            metodosCursos= new MetodosCursos();
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
        if(frm_Inicio.fuente.equals("BD"))
        {
            this.conexion=conexion;
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                agregarBD();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                buscarBD();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                modificarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                modificarBD();
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                eliminarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                eliminarBD();
        }
    }
    /// Metodos AP ///
    public void buscarAP() 
    {
        if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
    }
    public void agregarAP()
    {
        metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void modificarAP()
    {
        metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void eliminarAP()
    {
        metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
    /// Metodos BD///
    public void buscarBD() 
    {
        if(conexion.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(conexion.getArregloCursos());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
    }
    public void agregarBD()
    {
        conexion.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void modificarBD()
    {
        conexion.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void eliminarBD()
    {
        conexion.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
}
