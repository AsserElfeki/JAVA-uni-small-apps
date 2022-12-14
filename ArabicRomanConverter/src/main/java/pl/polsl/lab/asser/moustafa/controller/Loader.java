/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.controller;

import java.lang.annotation.Documented;
import javax.swing.JOptionPane;
import lombok.Data;
import pl.polsl.lab.asser.moustafa.model.*;
import pl.polsl.lab.asser.moustafa.view.AppWindow;
import pl.polsl.lab.asser.moustafa.view.View;

/**
 * Class that uses the <code>Class Model</code> and the <code>Class View</code>
 * objects and has all the communication functions between the MVC pattern
 * classes.
 * <p>
 * It has 3 different workflows depending on the mode of operation of the
 * current application run:
 * <ul>
 * <li><code>help()</code> : when the user provides only one argument, it uses
 * the <code>Class View</code> object to print help on the console to explain to
 * the user what arguments are needed.
 * <li><code>runWithoutArgs()</code> : when there are no arguments provided and
 * the program should prompt the user to enter a number.
 * <li><code>runWithTwoArgs()</code> : when the user provides the correct number
 * of arguments which is 2.
 * </ul>
 *
 * @author asser.elfeki
 * @version 1.0
 */
@Data
public class Loader {

    /**
     * Field for the inner object of <code>Class AppWindow</code>
     */
    private final AppWindow appWindow = new AppWindow();

    /**
     * Field for the inner object of <code>Class View</code>
     */
    private final View view = new View();

    /**
     * Field for the inner object of <code>Class Model</code>
     */
    private final Model model = new Model(appWindow);

    /**
     * Default non-parametric constructor
     */
    public Loader() {
    }

    /**
     * Function that runs the program in the Swing GUI.
     * it listens to events on the convert button and handles it.
     */
    public void runFromGUI() {
        appWindow.getConvertBtn().addActionListener(e -> {
            try {
                if (appWindow.getArToRn().isSelected()) {
                    if (model.isNumeric(appWindow.getInput().getText())) {
                        model.validateArabicNotation(appWindow.getInput().getText());
                    } else {
                        throw new IllegalArgumentException("Illegal arguments: non-numeric values entered");
                    }
                } else {
                    if (model.isRoman(appWindow.getInput().getText())) {
                        model.validateRomanNotation(appWindow.getInput().getText());
                    } else {
                        throw new IllegalArgumentException("Illegal arguments: non-roman characters entered");
                    }
                }
                if (model.getOutput() != null) {
                    appWindow.getOutput().setText("Converted number: \n" + model.getOutput());
                }
            } catch (IllegalArgumentException ex) {
                appWindow.showWarning(ex.getMessage());
            }

        });
    }

    /**
     * Uses the <code>Class View</code> object to print a guide on how to use
     * the application and what arguments to provide
     */
    @Deprecated
    public void help() {
        view.printHelp();
    }

    /**
     * Contains the algorithm used when no arguments are provided in the command
     * line.
     * <p>
     * Uses methods from both the model and the view to:
     * <ul>
     * <li>prompt the user to enter an input number.
     * <li>validate it.
     * <li>handle exceptions.
     * </ul>
     */
    @Deprecated
    public void runWithoutArgs() {

        while (model.getOutput() == null) {
            try {
                view.promptUser();
                model.processInput(view.read());
            } catch (InvalidCharacterException | IllegalArgumentException e) {

                view.logExceptionToConsole(e.getMessage());
            }

        }
    }

    /**
     * Contains the algorithm used when 2 arguments are provided in the command
     * line.
     *
     * @param args is the list of <code>String</code> arguments provided by the
     * user in the command line
     * @throws IllegalArgumentException in 2 cases:
     * <ul>
     * <li>direction of conversion is set to Arabic to Roman but the entered
     * input is a non-numeric value.
     * <li>direction of conversion is set to Roman to Arabic but the entered
     * input is or contains non-Roman characters.IllegalArgumentException.
     * </ul>
     */
    @Deprecated
    public void runWithTwoArgs(String[] args) throws IllegalArgumentException {

        while (model.getOutput() == null) {
            if (null != args[0]) {
                switch (args[0].toLowerCase()) {
                    case "-a" -> {
                        if (model.isNumeric(args[1])) {
                            model.validateArabicNotation(args[1]);
                        } else {
                            throw new IllegalArgumentException("You entered a non-umeric value.");
                        }
                    }
                    case "-r" -> {
                        if (model.isRoman(args[1])) {
                            model.validateRomanNotation(args[1]);
                        } else {
                            throw new IllegalArgumentException("You entered a non-roman characters.");
                        }
                    }
                    default ->
                        throw new IllegalArgumentException("Invalid arguments");
                }
            }
        }
    }

    /**
     * uses the <code>Class View</code> methods to log Exception messages to the
     * console.
     *
     * @param message is the String message of a specific exception.
     */
    @Deprecated
    public void logException(String message) {
        view.logExceptionToConsole(message);
    }

    /**
     * Checks if output exists then uses the <code>Class View</code> method
     * <code>outputConvertedNumber(String output)</code> to display it on the
     * console.
     */
    @Deprecated
    public void getOutput() {
        if (model.getOutput() != null) {
            view.outputConvertedNumber(model.getOutput());
        }

    }

}
