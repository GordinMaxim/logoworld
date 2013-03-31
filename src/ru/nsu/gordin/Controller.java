package ru.nsu.gordin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.nsu.gordin.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Controller class which implement controller from MVC pattern
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Controller {
    private boolean firstRun = true;
    private Factory factory = null;
    final static private Logger log = Logger.getLogger(Controller.class);
    /**
     * method which run all game
     *
     * @param fact reference to a abstract factory
     * @param viewer reference to a Viewer
     * @throws InstantiationException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws IOException
     */
    void run(Factory fact, Viewer viewer) throws Exception {
        log.debug("void Controller.run(Abstract factory fact = "+fact+", Viewer viewer = "+viewer+")");
        factory = fact;
        Model model = new Model();
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));

        if(null == fact)
        {
            throw new Exception("fact == null");
        }
        if(null == viewer)
        {
            throw new Exception("viewer == null");
        }

        while(true)
        {
            String s = bufReader.readLine();
            s = s + ' ';
            String sub = s.substring(0, s.indexOf(' '));
            String param = s.substring(s.indexOf(' ') + 1);
            if(firstRun)
            {
                if(sub.equals("INIT") || sub.equals("EXIT"))
                {
                    firstRun = false;
                }
                else
                {
                    viewer.printMessage("Not initialized, try again");
//                    System.out.println("Not initialized, try again");
                    continue;
                }
            }
            Command fun = factory.create(sub);
            if(null == fun)
            {
                viewer.printMessage("command not found");
                continue;
            }
            fun.action(param, viewer, model);



            viewer.print(model);

        }
    }
}
