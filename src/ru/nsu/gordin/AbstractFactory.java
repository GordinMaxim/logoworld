package ru.nsu.gordin;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
//fsdgfbksdf


/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/2/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractFactory {
    static private Map<String, String> paths = new HashMap<>();
    static private Map<String, Class> creators = new HashMap<>();

    static public void init(String fileName) throws IOException {
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

    static public Object create(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(!paths.containsKey(key))
        {
            throw new ClassNotFoundException(key);
        }
        if(!creators.containsKey(key))
        {
            creators.put(key, Class.forName(paths.get(key)));
        }

        return creators.get(key).newInstance();
    }


}
