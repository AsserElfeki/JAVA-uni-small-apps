/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.controller;

import pl.polsl.lab.asser.moustafa.model.Model; 
import pl.polsl.lab.asser.moustafa.view.View; 

/**
 * Main class that instantiates a model object and a view object
 * it catches the entered by user numeral and passes it to the model object
 * it catches the processed numeral from the model obj and passes it back to the view
 * 
 * @author asser.elfeki
 */
public class Controller {
    
    /** the converted numeral is saved here*/
    private String convertedNum;
    
    /**\
     * 
     * @param processedNum 
     */
    public void setConvertedNum(String processedNum){
        
    }
    
    /**
     * 
     * @return 
     */
    public String getConvertedNum(){
        
    }
    
    /**
     * main method of the app. 
     * 
     * @param args 
     */
    public static void main(String[] args){
        View view = new View();
        //pass the user input to validator
        // validator passes it to according converter
        // converter will convert and pass back the output 
        Model model = new Model(view.read());
        
        

        
        
        /*
        TODO: 
        make view and model objects 
        use the view method which reads input 
        get this input 
        pass it to the model 
        use model method that verifies the input
        then process the input 
        pass the processed input back 
        the controller passes the processed input to the view (output)
        the view outputs it 
        */
    }
}
