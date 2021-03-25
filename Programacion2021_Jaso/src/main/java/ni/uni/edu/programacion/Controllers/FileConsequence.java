/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class FileConsequence {
    private File file;
    private FileOutputStream fos;
    private FileInputStream fis;
    
    public FileConsequence(File file){
        this.file = file;
    }
    
    public void write(File file, String text) throws IOException{
        if (!file.exists()){
            file.createNewFile();
        }
        
        openFos(file);
        
        fos.write(text.getBytes());
    }
    
    private void openFos(File file) throws FileNotFoundException {
        fos = new FileOutputStream(file,true);
    }
    
    
    public String read(File file) throws IOException{
        if (fis == null){
           OpenFis(file); 
        }
        
        String text = "";
        int n;

        while((n = fis.read()) != -1 ){
           text += (char) n;
        }
        
        
        return text;
    }
    
    public void OpenFis(File file) throws FileNotFoundException{
        fis = new FileInputStream(file);
    }
    
    public void close() throws IOException{
        if (fos != null){
            fos = null;
            fos.close();
        }
        
        if (fis != null){
            fis = null;
            fis.close();
        }
    }
}
