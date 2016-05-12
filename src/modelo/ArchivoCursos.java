/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ArchivoCursos {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public void crearArchivo()
    {
      try
      {
          archivoSalida = new ObjectOutputStream(new FileOutputStream("cursos.dat"));
          System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Curso curso)
    {
      try
      {
            archivoSalida.writeObject(curso);
            System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
            System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public ArrayList<Curso> devolverInformacionCompleta()
    {
      ArrayList<Curso> arrayCursos = new ArrayList <Curso>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("cursos.dat"));
        while(true)
        {
          arrayCursos.add((Curso)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayCursos;
    }
}