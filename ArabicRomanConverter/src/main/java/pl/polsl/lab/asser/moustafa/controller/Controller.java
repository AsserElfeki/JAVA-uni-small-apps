/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.controller;

import pl.polsl.lab.asser.moustafa.model.*; 
import pl.polsl.lab.asser.moustafa.view.View; 

/**
 * Main class that instantiates a model object and a view object
 * it catches the entered by user numeral and passes it to the model object
 * it catches the processed numeral from the model obj and passes it back to the view
 * @author asser.elfeki
 * @version 1.1
 */
public class Controller {
    private View view; 
    
    private Model model; 
    /**
     * main method of the app. 
     * 
     * @param args not used
     */
    public static void main(String[] args){
        View view = new View();
        
        Model model = new Model(view);
        
        while (model.getOutput() == null){
            try{
                view.promptUser();
                model.processInput(view.read());
            }
            catch (InvalidCharacterException | IllegalArgumentException e){
                
                view.logExceptionToConsole(e.getMessage());
            }
        }
        
        view.outputConvertedNumber(model.getOutput());                 
    }
    
}


