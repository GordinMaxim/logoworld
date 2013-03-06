package ru.nsu.gordin;

import ru.nsu.gordin.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static void run() throws InstantiationException, ClassNotFoundException, IllegalAccessException, IOException {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String s = bufReader.readLine();
            s = s + ' ';
            String sub = s.substring(0, s.indexOf(' '));
            String param = s.substring(s.indexOf(' ') + 1);
            if(firstRun)
            {
                if(0 == sub.compareTo("INIT"))
                {
                    firstRun = false;
                }
                else
                {
                    System.out.println("Not initialized, try again");
                    continue;
                }
            }
            Command fun = AbstractFactory.create(sub);
            fun.action(param);

//            if(obj instanceof Init)
//            {
//                Init fun = (Init)obj;
//                fun.action(param);
//            }
//            else if(obj instanceof Move)
//            {
//                Move fun = (Move)obj;
//                fun.action(param);
//            }
//            else if(obj instanceof Teleport)
//            {
//                Teleport fun = (Teleport)obj;
//                fun.action(param);
//            }
//            else if(obj instanceof Ward)
//            {
//                Ward fun = (Ward)obj;
//                fun.action(param);
//            }
//            else if(obj instanceof Draw)
//            {
//                Draw fun = (Draw)obj;
//                fun.action(param);
//            }
//            else
//            {
//                System.out.println("Unknown command");
//            }

            Viewer.print(Model.getField());

        }
    }
}
