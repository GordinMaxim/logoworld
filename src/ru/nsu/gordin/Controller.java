package ru.nsu.gordin;

import ru.nsu.gordin.commands.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    static boolean firstRun = true;
    static void run() throws InstantiationException, ClassNotFoundException, IllegalAccessException
    {
        Scanner scanner = new Scanner(System.in);
        String s;
        while(true)
        {

            s = scanner.next();
            if(firstRun)
            {
                if(0 == s.compareTo("INIT"))
                {
                    firstRun = false;
                }
                else
                {
                    System.out.println("Not initialized, try again");
                    continue;
                }
            }
            Object obj = AbstractFactory.create(s);
            StringBuilder sb = new StringBuilder();
            while(scanner.hasNext())
            {
                sb.append(scanner.next() + " ");
            }

            if(obj instanceof Init)
            {
                Init fun = (Init)obj;
                fun.action(sb.toString());
            }
            else if(obj instanceof Move)
            {
                Move fun = (Move)obj;
                fun.action(sb.toString());
            }
            else if(obj instanceof Teleport)
            {
                Teleport fun = (Teleport)obj;
                fun.action(sb.toString());
            }
            else if(obj instanceof Ward)
            {
                Ward fun = (Ward)obj;
                fun.action(sb.toString());
            }
            else if(obj instanceof Draw)
            {
                Draw fun = (Draw)obj;
                fun.action(sb.toString());
            }
            else
            {
                System.out.println("Unknown command");
            }

            Viewer.print(Model.getField());

        }
    }
}
