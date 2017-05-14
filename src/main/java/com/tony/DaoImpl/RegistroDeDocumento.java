/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;
import java.io.*; 
/**
 *
 * @author lzJonathanHz
 */
public class RegistroDeDocumento {
    FileInputStream entrada;
    FileOutputStream salida;
    File Archivo;
    
    public RegistroDeDocumento(){
    
    
    }
    
    /*Guardar Archvo de texto*/
    public String GruardarAtexto (File archivo,String contenido){
        String respuesta=null; 
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTex=contenido.getBytes();
            salida.write(bytesTex);
            respuesta="se guardo con exito el archivo";
        } catch (Exception e) {
        }
        return respuesta;
    }
    /*Abrir un imagen*/
    
    public byte[] AbrirAImagen(File archivo){
         byte[] bytesImg=new byte[1024*100];
         try {
            entrada=new FileInputStream(Archivo);
            entrada.read(bytesImg);
        } catch (Exception e) {
        }
        return bytesImg;  
    }
    
    /*Guardar Imagen*/
    public String GuardarImagen(File Archivo,byte[] bytesImg){
        
        String respuesta=null;
        try {
            salida=new FileOutputStream(Archivo);
            salida.write(bytesImg);
            respuesta = "se guardo correctamente";
        } catch (Exception e) {
        }
        return respuesta;
    
    
    }
}
    