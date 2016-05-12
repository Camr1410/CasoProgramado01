
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

public class Controlador_FRM_Matricula implements ActionListener{
    
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    public MetodosMatricula metodosMatricula;
    FRM_Matricula frm_Matricula;
    FRM_Inicio frm_Inicio;
    boolean verificarEstudiante=false,verificarCurso=false;
    
    public Controlador_FRM_Matricula(FRM_Inicio frm_Inicio,FRM_Matricula frm_Matricula,FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            this.metodosEstudiantes=frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
            this.metodosCursos=frm_MantenimientoCursos.controlador_FRM_MantenimientoCursos.metodosCursos;
            this.frm_Matricula=frm_Matricula;
            metodosMatricula= new MetodosMatricula(this,metodosEstudiantes,metodosCursos,frm_Matricula);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar Estudiante"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarEstudianteAP();
        }
        if(e.getActionCommand().equals("Consultar Curso"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarCursoAP();
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                finalizarAP();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                consultarAP();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
               eliminarAP();
        }
        if(e.getActionCommand().equals("Modificar")) 
        {
            frm_Matricula.resetearVentana();
        }  
        verificarConsultas();
    }
    /// Metodos AP ///
    public void buscarEstudianteAP()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
            frm_Matricula.mostrarInformacionEstudiante(metodosEstudiantes.getNombreEncontrado());
            verificarEstudiante=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_Matricula.limpiarCamposEstudiante();
            verificarEstudiante=false;
        }
    }
    public void buscarCursoAP()
    {
        if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(metodosCursos.getNombreEncontrado());
            verificarCurso=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra.");
            frm_Matricula.limpiarCamposCurso();
            verificarCurso=false;
        }
    }
    public void agregarAP()
    {
        frm_Matricula.agregarInformacionTabla();
        frm_Matricula.limpiarCamposCurso();
        frm_Matricula.habilitarFinalizar();
        verificarCurso=false;
        verificarConsultas();
    }     
    public void finalizarAP()
    {
        String arreglo[]= new String[3];
        for(int contador=0;contador<frm_Matricula.getCantidadFilas();contador++)
        {
            arreglo[0]=frm_Matricula.devolverCodigo();
            arreglo[1]=frm_Matricula.devolverDato(contador,1);
            arreglo[2]=frm_Matricula.devolverDato(contador,3);
            metodosMatricula.agregarMatricula(arreglo);
        }
        frm_Matricula.colocarCodigo();
        frm_Matricula.resetearVentana();
        verificarEstudiante=false;
        verificarCurso=false;
        frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarAP()
    {
        if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
        {
            frm_Matricula.deshabilitarCamposEstudiante();
            frm_Matricula.deshabilitarCamposCurso();
            frm_Matricula.habilitarEliminar();
            frm_Matricula.habilitarModificar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("No se encuentra ese código de matricula registrado");
            frm_Matricula.resetearVentana();
        }
    }
    public void eliminarAP()
    {
        if(frm_Matricula.devolverFilaSeleccionada()>=0)
        {
            metodosMatricula.eliminarMatricula(frm_Matricula.devolverMatriculaSeleccionada());
            frm_Matricula.eliminarFilaSeleccionada();
        }
        else
        {
            frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
        }
    }
    
    
    
    public void verificarConsultas()
    {
        if(verificarEstudiante && verificarCurso)
        {
            frm_Matricula.habilitarAgregar();
            frm_Matricula.deshabilitarCamposEstudiante();
        }
        else
        {
            frm_Matricula.deshabilitarAgregar();
        }
    }
}