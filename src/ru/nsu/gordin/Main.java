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
//            getClass().getPackage().getName().replace()
            PropertyConfigurator.configure("log4j.properties");
            final Logger log = Logger.getLogger(Main.class);

            String initFact = null;
            if(0 == args.length)
            {
                initFact = "initFile.properties";
            }
            else if(1 == args.length)
            {
                initFact = args[0];
            }
            else
            {
                log.error("too many args");
            }

            log.debug("DEBUUUUGGG");

            log.info("creating factory");
            Factory factory = new Factory();

            log.info("factory init");
            factory.init(initFact);

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
