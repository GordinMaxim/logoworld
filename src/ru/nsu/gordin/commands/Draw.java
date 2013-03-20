package ru.nsu.gordin.commands;

import ru.nsu.gordin.Model;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/2/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
import ru.nsu.gordin.Viewer;

/**
 * This class implement interface Command and execute a user command DRAW
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Draw implements Command{
    /**
     * set draw-flag true
     *
     * @param parametres empty string
     * @param viewer specimen of class Viewer
     * @param model specimen of class Model
     */
    @Override
    public void action(String parametres, Viewer viewer, Model model)
    {
        if(!parametres.isEmpty())
        {
            viewer.printMessage("Draw has no parametres");
//            System.out.println("Draw has no parametres");
            return;
        }

        model.setDraw(true);
    }
}
