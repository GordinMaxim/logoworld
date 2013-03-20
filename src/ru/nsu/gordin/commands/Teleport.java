package ru.nsu.gordin.commands;

import ru.nsu.gordin.Model;
import ru.nsu.gordin.Viewer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 2/28/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class implement interface Command and execute a user command TELEPORT
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Teleport implements Command{
    /**
     * teleport player on new position
     *
     * @param parametres string "<x> <y>"
     * @param viewer specimen of class Viewer
     * @param model specimen of class Model
     */
    @Override
    public void action(String parametres, Viewer viewer, Model model)
    {
        int x = 0;
        int y = 0;

        Scanner scanner = new Scanner(parametres);

        if(scanner.hasNextInt())
        {
            x = scanner.nextInt();
        }

        if(scanner.hasNextInt())
        {
            y = scanner.nextInt();
        }


        if(scanner.hasNext())
        {
            viewer.printMessage("Use: TELEPORT <x> <y>");
        }

        model.set(x, y);

    }
}
