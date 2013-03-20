package ru.nsu.gordin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.nsu.gordin.commands.Command;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/2/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * AbstractFactory is abstract factory class which produce implementations of interface {@link Command}
 *
 * @author Gordin Maxim
 * @version 1.0
 */
public class AbstractFactory {
    private Map<String, String> paths = new HashMap<>();
    private Map<String, Class> creators = new HashMap<>();
    static private Logger log = null;
    static
    {
        PropertyConfigurator.configure("log4j.properties");
        log = Logger.getLogger(AbstractFactory.class);
    }
    /**
     * Initialized factory with settings in fileName
     *
     * @param fileName name of file where store string "command name"="full name of class which execute this command"
     * @throws IOException
     */
    public void init(String fileName) throws IOException {

        log.debug("void AbstractFactory.init(String filename = "+fileName+")");
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
        if(null == stream)
        {
            throw new FileNotFoundException(fileName);
        }

        Properties prop = new Properties();
        prop.load(stream);
        Enumeration<?> keyList = prop.propertyNames();

        while(keyList.hasMoreElements())
        {
            String key = (String)keyList.nextElement();
            paths.put(key, prop.getProperty(key));
        }
    }

    /**
     * create a specimen of class which implement interface Command
     *
     * @param key the name of command
     * @return reference to one of implementation of interface Command
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Command create(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        log.debug("Command AbstractFactory.create(String key = "+key+")");
        if(!paths.containsKey(key))
        {
//            throw new ClassNotFoundException("command"+key+" not found");
            return null;
        }
        if(!creators.containsKey(key))
        {
            creators.put(key, Class.forName(paths.get(key)));
        }

        return (Command)creators.get(key).newInstance();
    }


}
