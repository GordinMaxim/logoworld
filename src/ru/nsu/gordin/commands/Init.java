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
public class Init {
    public void action(String parametres)
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
            x = scanner.nextInt();
        }
        if(scanner.hasNextInt())
        {
            y = scanner.nextInt();
        }

        if(scanner.hasNext())
        {
            System.out.println("Too many parametres, must be: \" INIT <width> <heigth> <x> <y>\" ");
            return;
        }
        else
        {
            Model.init(width, heigth, x, y);
        }

    }

}
