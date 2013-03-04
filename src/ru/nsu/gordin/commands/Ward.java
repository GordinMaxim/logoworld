package ru.nsu.gordin.commands;

import ru.nsu.gordin.Model;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/2/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ward {
    public void action(String parametres)
    {
        if(!parametres.isEmpty())
        {
            System.out.println("Ward has no parametres");
            return;
        }

        Model.setDraw(false);
    }
}
