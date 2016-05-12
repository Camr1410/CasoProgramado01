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
public class ArchivoUsuarios {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public void crearArchivo()
    {
      try
      {
          archivoSalida = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
          System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Usuario usuario)
    {
      try
      {
            archivoSalida.writeObject(usuario);
            System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
            System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public ArrayList<Usuario> devolverInformacionCompleta()
    {
      ArrayList<Usuario> arrayUsuarios = new ArrayList <Usuario>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
        while(true)
        {
          arrayUsuarios.add((Usuario)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayUsuarios;
    }
}
