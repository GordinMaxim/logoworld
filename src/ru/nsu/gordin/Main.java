package ru.nsu.gordin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 2/28/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */


public class Main {
    public static void main(String[] args)
    {
        try
        {
            PropertyConfigurator.configure("log4j.properties");
            Logger log = Logger.getLogger(Main.class);

            log.debug("DEBUUUUGGG");

            log.info("creating factory");
            AbstractFactory factory = new AbstractFactory();

            log.info("factory init");
            factory.init(args[0]);

            log.info("creating controller");
            Controller contrl = new Controller();

            log.info("creating viewer");
            Viewer viewer = new Viewer();

            log.info("controller run...");
            contrl.run(factory, viewer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
