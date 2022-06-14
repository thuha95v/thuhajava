/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author admin 
 */
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileService {
    //ghi file
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    //doc file
    private Scanner scanner;
    private String fileName;
    
    public FileService(String fileName) {
        this.fileName = fileName;
    }
   
    public void openFileToWrite(){
        try {
            this.fileWriter = new FileWriter(fileName, false); //
            this.bufferedWriter = new BufferedWriter(fileWriter);
            this.printWriter = new PrintWriter(bufferedWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void closeFileAfterWrite(){
        try {
            this.printWriter.close();
            this.bufferedWriter.close();
            this.fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void openFileToRead(){
        try {
            this.scanner = new Scanner(Paths.get(fileName));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void closeFileAfterRead(){
        this.scanner.close();
    }
    
    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public Scanner getScanner(){
        return this.scanner;
    }
    
    
    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}