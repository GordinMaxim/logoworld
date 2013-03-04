package ru.nsu.gordin.commands;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 2/28/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Teleport {
    public void action(String parametres)
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
            System.out.println("Too many parametres, must be: TELEPORT <x> <y>");
        }

    }
}
