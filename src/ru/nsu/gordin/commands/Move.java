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
public class Move {
    public void action(String parametres)
    {
        int steps = 0;
        String direction = null;


        Scanner scanner = new Scanner(parametres);
        if(scanner.hasNext())
        {
            direction = scanner.next();
            if(1 != direction.length())
            {
                System.out.println("Must be one of [L|R|U|D]");
            }
        }
        if(scanner.hasNextInt())
        {
            steps = scanner.nextInt();
        }

        if(scanner.hasNext())
        {
            System.out.println("Too many parametres, must be: \" MOVE [L|R|U|D] <steps>\" ");
            return;
        }
        else
        {
            while(steps > 0)
            {
                Model.step(direction);
                steps--;
            }
        }
    }
}
