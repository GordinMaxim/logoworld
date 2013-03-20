package ru.nsu.gordin.commands;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.nsu.gordin.Model;
import ru.nsu.gordin.Viewer;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/6/13
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Interface for user command classes
 *
 * @author Gordin Maxim
 * @version 1.0
 */
public interface Command {
    /**
     * prototype of command execution
     *
     * @param parametres
     * @param viewer
     * @param model
     */
    void action(String parametres, Viewer viewer, Model model);
}
