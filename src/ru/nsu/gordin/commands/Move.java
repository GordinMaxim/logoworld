package ru.nsu.gordin.commands;

import ru.nsu.gordin.Model;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/2/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
import ru.nsu.gordin.Viewer;

/**
 * This class implement interface Command and execute a user command MOVE
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Move implements Command{
    /**
     * move player position
     *
     * @param parametres string which looks like "[L|R|U|D] [0-9]"
     * @param viewer specimen of class Viewer
     * @param model specimen of class Model
     */
    @Override
    public void action(String parametres, Viewer viewer, Model model)
    {
        int steps = 0;
        String direction = null;


        Scanner scanner = new Scanner(parametres);
        if(scanner.hasNext())
        {
            direction = scanner.next();
            if(1 != direction.length() || !(new String("LRUD").contains(direction)))
            {
                viewer.printMessage("Must be one of [L|R|U|D]");
//                System.out.println("Must be one of [L|R|U|D]");
            }
        }
        if(scanner.hasNextInt())
        {
            steps = scanner.nextInt();
        }

        if(scanner.hasNext())
        {
            viewer.printMessage("Use: \" MOVE [L|R|U|D] <steps>\" ");
//            System.out.println("Too many parametres, must be: \" MOVE [L|R|U|D] <steps>\" ");
            return;
        }
        else
        {
            while(steps > 0)
            {
                model.step(direction);
                steps--;
            }
        }
    }
}
