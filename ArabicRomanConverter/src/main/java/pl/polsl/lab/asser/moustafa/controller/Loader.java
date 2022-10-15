/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.controller;

import pl.polsl.lab.asser.moustafa.model.*;

import pl.polsl.lab.asser.moustafa.view.View;

/**
 *
 * @author asser.elfeki
 */
public class Loader {

    private View view = new View();

    private Model model = new Model(view);

    public void help() {
        view.printHelp();
    }

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

    public void runWithTwoArgs(String[] args) throws IllegalArgumentException{
        while (model.getOutput() == null) {
            if ("-a".equals(args[0].toLowerCase())) {

                if (model.isNumeric(args[1])) {
                    model.validateArabicNotation(args[1]);
                } else {
                    throw new IllegalArgumentException("You entered a non-umeric value.");                  
                }
            } else if ("-r".equals(args[0].toLowerCase())) {
                if (model.isRoman(args[1])) {
                    model.validateRomanNotation(args[1]);
                } else {
                    throw new IllegalArgumentException("You entered a non-roman characters.");                  

                }
            } else {
                throw new IllegalArgumentException("Invalid arguments");                  

            }
        }

    }

    public void logException(String message) {
        view.logExceptionToConsole(message);
    }

    public void getOutput() {
        if (model.getOutput() != null) {
            view.outputConvertedNumber(model.getOutput());
        }

    }
}
