package ru.nsu.gordin.commands;

import ru.nsu.gordin.Model;
import ru.nsu.gordin.Viewer;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/10/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class implement interface Command and execute a user command EXIT
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Exit implements Command {

    /**
     * exit from the program
     *
     * @param parametres any string, don't matter
     * @param viewer specimen of class Viewer
     * @param model specimen of class Model
     */
    @Override
    public void action(String parametres, Viewer viewer, Model model) {
        viewer.printMessage("Bye");
        System.exit(0);
    }
}
