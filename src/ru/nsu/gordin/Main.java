package ru.nsu.gordin;
/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 2/28/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;

public class Main {
    public static void main(String argc[])
    {
        try
        {
            AbstractFactory.init(argc[1]);
            Controller.run();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InstantiationException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
