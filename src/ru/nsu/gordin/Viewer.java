package ru.nsu.gordin;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Viewer {
    static public void print(char[][] field)
    {

        for(int i = 0; i < field.length; i++)
        {
            System.out.print(field[i]);
        }
    }

}
