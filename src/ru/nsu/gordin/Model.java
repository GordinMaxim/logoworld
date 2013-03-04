package ru.nsu.gordin;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Model {
    static private char[][] field = null;
    static private int x = -1;
    static private int y = -1;
    static private boolean drawing = false;

    static public boolean init(int width, int heigth, int x1, int y1)
    {
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
        field[x][y] = 'X';
        return true;
    }
    static public int getX()
    {
        return x;
    }
    static public int getY()
    {
        return y;
    }
    static public void setDraw(boolean b)
    {
        drawing = b;
    }

    static public void step(String direction)
    {
        if(drawing)
        {
            field[x][y] = 'o';

        }
        else
        {
            field[x][y] = '.';
        }
        if(0 == direction.compareTo("L"))
        {
            x--;
            if(0 > x)
            {
                x += field[0].length;
            }
        }
        else if(0 == direction.compareTo("R"))
        {
            x++;
            x %= field[0].length;
        }
        else if(0 == direction.compareTo("U"))
        {
            y--;
            if(0 > y)
            {
                y += field.length ;
            }
        }
        else if(0 == direction.compareTo("D"))
        {
            y++;
            x %= field.length;
        }
        field[x][y] = 'X';

    }

    static char[][] getField()
    {
        return field;
    }

    static public void set(int x1, int y1)
    {
        x = x1;
        y = y1;
    }

}
