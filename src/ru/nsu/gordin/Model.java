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

/**
 * Model is a public class which store a field and player position,
 * and give users set of primitive methods to control it
 *
 * @author Gordin Maxim
 * @version 0.9
 */
public class Model {
    private char[][] field = null;
    private int x = -1;
    private int y = -1;
    private boolean drawing = false;
    static private Logger log = null;
    static
    {
        PropertyConfigurator.configure("log4j.properties");
        log = Logger.getLogger(Model.class);
    }

    /**
     * Initialize field of the logoworld
     *
     * @param width of field
     * @param heigth of field
     * @param x1 first coordinate of start position
     * @param y1 second coordinate of start position
     * @return true if field has been initialized, otherwise false
     */
    public boolean init(int width, int heigth, int x1, int y1)
    {
        log.debug("boolean Model.init(int width = "+width+", int heigth = "+heigth+", int x1 = "+x1+", int y1 = "+y1+")");
        if(0 > width || 0 > heigth)
        {
            return false;
        }
        if(0 > x1 || 0 > y1)
            return false;

        field = new char[width][heigth];
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < heigth; j++)
            {
                field[i][j] = '.';
            }
        }
        x = x1;
        y = y1;
//        field[x][y] = 'X';
        return true;
    }

    /**
     * return first coordinate of player
     *
     * @return first coordinate of player
     */
    public int getX()
    {
        log.debug("int Model.getX()");
        return x;
    }

    /**
     * return second coordinate of player
     *
     * @return second coordinate of player
     */
    public int getY()
    {
        log.debug("int Model.getY()");
        return y;
    }

    /**
     * set flag which leaves a visible track when player move
     *
     * @param b a boolean value which set flag
     */
    public void setDraw(boolean b)
    {
        log.debug("void Model.SetDraw(boolean b = "+b+")");
        drawing = b;
    }


    /**
     * make one step in a given direction
     *
     * @param direction direction in format [L|R|U|D]
     * @return void
     */
    public void step(String direction)
    {
        log.debug("void Model.step(String direction  = "+direction+")");
        if(drawing)
        {
            field[x][y] = 'o';

        }
//        else
//        {
//            field[x][y] = '.';
//        }
        if(0 == direction.compareTo("L"))
        {
            y--;
            if(0 > y)
            {
                y += field[0].length;
            }
        }
        else if(0 == direction.compareTo("R"))
        {
            y++;
            y %= field[0].length;
        }
        else if(0 == direction.compareTo("U"))
        {
            x--;
            if(0 > x)
            {
                x += field.length ;
            }
        }
        else if(0 == direction.compareTo("D"))
        {
            x++;
            x %= field.length;
        }
//        field[x][y] = 'X';

    }

    /**
     * return char[][] field of the game
     *
     * @return char[][] field of the game
     */
    char[][] getField()
    {
        log.debug("char[][] Model.getField()");
        return field;
    }

    /**
     * set new position with coordinates x1 and y1,
     * in contrast with {@link Model;} don't leave a trail even if set drawing true
     *
     * @param x1 new first coordinate
     * @param y1 new second coordinate
     */
    public void set(int x1, int y1)
    {
        log.debug("void Model.set(int x1 = "+x1+", int y1 = "+y1+")");
//        field[x][y] = '.';
        x = x1 % field.length;
        y = y1 % field[0].length;
//        field[x][y] = 'X';
    }

}
