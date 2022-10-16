/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.controller;

/**
 * Main class of the program, it acts as the intermediary between the
 * <code>class Model</code> and the <code>class View</code> so the proper
 * separation between logic and user interface is implemented.
 * <p>
 * Receives input from command line arguments or from the user's input in the
 * console, via the <code>class View</code> object. Manipulates the
 * <code>class Model</code> object by passing this data to it. Gets the data
 * back and passes it again to the <code>class View</code> object.
 * <p>
 * It instantiates a <code>class Loader</code> object then depending on the
 * number of provided arguments runs the proper <code>class Loader</code>
 * methods.
 *
 * @author asser.elfeki
 * @version 1.2
 */
public class Controller {
    
    /**
     * Default non-parametric constructor
     */
    public Controller(){
        
    }

    /**
     * main method of the app.
     * Work flow:
     * <ol>
     * <li>Creates <code>Class Loader</code> object.
     * <li>Checks number of provided arguemnts.
     * <li>Tries to call the proper <code>Class Loader</code> method.
     * <li>Catches the Exceptions if any.
     * <li>updates the <code>Class View</code> object.
     * </ol>
     * @param args List of strings representing arguments given by the user in the command line
     * to specify the direction of number conversion and the input number.      
     */
    public static void main(String[] args) {

        Loader loader = new Loader();

        if (args.length < 1) {
            loader.runWithoutArgs();
        } else if (args.length == 1) {
            loader.help();
        } else if (args.length == 2) {
            try {
                loader.runWithTwoArgs(args);
            } catch (IllegalArgumentException e) {
                loader.logException(e.getMessage());
            }

        } else {
            loader.logException("Invalid arguments");
        }
        loader.getOutput();

    }
}
