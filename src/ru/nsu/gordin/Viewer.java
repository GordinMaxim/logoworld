package ru.nsu.gordin;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.nsu.gordin.Model;

/**
 * Viewer class which implement viewer class from pattern MVC
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Viewer {
    final static private Logger log = Logger.getLogger(Viewer.class);
    /**
     * print message on the screen
     *
     * @param message print message
     */
    public void printMessage(String message)
    {
        log.debug("void Viewer.printMessage(String = "+message+")");
        System.out.println(message);
    }

    /**
     * print field and player on the screen
     *
     * @param model specimen of class Model
     */
    public void print(Model model)
    {
        log.debug("void Viewer.print(Model = "+model+")");
        char[][] field = model.getField();
        for(int i = 0; i < field.length; i++)
        {
            if(i != model.getX())
            {
                System.out.println(field[i]);
            }
            else
            {
                for(int j = 0; j < field[i].length; j++)
                {
                    if(j != model.getY())
                    {
                        System.out.print(field[i][j]);
                    }
                    else
                    {
                        System.out.print('X');
                    }
                }
                System.out.print('\n');
            }
        }
    }

}
