package ru.nsu.gordin;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/21/13
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public enum CommandTypes {
    LEFT('L'), RIGHT('R'), UP('U'), DOWN('D') ;
    char c;

    private CommandTypes(char c) {
        this.c = c;
    }

    public static CommandTypes decoder(char s)
    {
        switch (s)
        {
            case 'L' : return LEFT;
            case 'R' : return RIGHT;
            case 'U' : return UP;
            case 'D' : return DOWN;
        }
        return null;

    }

}

