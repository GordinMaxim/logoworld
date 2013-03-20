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
 * This class implement interface Command and execute a user command INIT
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Init implements Command{
    /**
     * initialize user field
     *
     * @param parametres string which looks like "<width> <heigth> <x> <y>"
     * @param viewer specimen of class Viewer
     * @param model specimen of class Model
     */
    @Override
    public void action(String parametres, Viewer viewer, Model model)
    {
        int x = 0;
        int y = 0;
        int width = 0;
        int heigth = 0;

        Scanner scanner = new Scanner(parametres);
        if(scanner.hasNextInt())
        {
            width = scanner.nextInt();
        }
        if(scanner.hasNextInt())
        {
            heigth = scanner.nextInt();
        }
        if(scanner.hasNextInt())
        {
            x = scanner.nextInt() % heigth;
        }
        if(scanner.hasNextInt())
        {
            y = scanner.nextInt() % width;
        }

        if(scanner.hasNext())
        {
            viewer.printMessage("Use: \" INIT <width> <heigth> <x> <y>\" ");
//            System.out.println("Too many parametres, must be: \" INIT <width> <heigth> <x> <y>\" ");
            return;
        }
        else
        {
            model.init(width, heigth, x, y);
        }

    }

}
