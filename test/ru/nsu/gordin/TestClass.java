package ru.nsu.gordin;

import org.junit.*;

import ru.nsu.gordin.commands.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: gormakc
 * Date: 3/14/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */

public class TestClass {
    @Test
    public void badCommandCreate()
    {
        try {
            Model m = new Model();
            AbstractFactory fact = new AbstractFactory();
            fact.init("ru/nsu/gordin/initFile.properties");

            Command command = fact.create("TELE#@@#PORT");
            Assert.assertEquals(null, command);

            command = fact.create("");
            Assert.assertEquals(null, command);

            command = fact.create("TELEPORT we we");
            Assert.assertEquals(null, command);

            command = fact.create("INIT qwd qwe");
            Assert.assertEquals(null, command);

            command = fact.create("DRAW 32 q");
            Assert.assertEquals(null, command);

            command = fact.create("WARD e#");
            Assert.assertEquals(null, command);

            command = fact.create("MOVE 32 s");
            Assert.assertEquals(null, command);

            command = fact.create("MOVE D D");
            Assert.assertEquals(null, command);
        }
        catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testModel()
    {
        int x;
        int y;
        Model m = new Model();
        Viewer viewer = new DegenerateViewer();

        Init init = new Init();
        Move move = new Move();
        Draw draw = new Draw();
        Ward ward = new Ward();
        Teleport teleport = new Teleport();

        init.action("20 30 4 3", viewer, m);
        Assert.assertEquals(3, m.getY());
        Assert.assertEquals(4, m.getX());
        Assert.assertEquals(20, m.getField().length);
        Assert.assertEquals(30, m.getField()[0].length);

        move.action("D 5", viewer, m);
        Assert.assertEquals(3, m.getY());
        Assert.assertEquals(9, m.getX());


        draw.action("", viewer, m);
        x = m.getX();
        y = m.getY();
        move.action("D 3", viewer, m);
        Assert.assertEquals('o', m.getField()[x][y]);
        Assert.assertEquals('o', m.getField()[x+1][y]);
        Assert.assertEquals('o', m.getField()[x+2][y]);

        ward.action("", viewer, m);
        x = m.getX();
        y = m.getY();
        move.action("D 3", viewer, m);
        Assert.assertEquals('.', m.getField()[x][y]);

        teleport.action("15 16", viewer, m);
        Assert.assertEquals(15, m.getX());
        Assert.assertEquals(16, m.getY());
    }


    @Test(expected = Exception.class)
    public void testControllerWithoutModel() throws Exception {
        Controller controller = new Controller();
        controller.run(null, new DegenerateViewer());
    }

    @Test(expected = Exception.class)
    public void testControllerWithoutViewer() throws Exception {
        Controller controller = new Controller();
        controller.run(new AbstractFactory(), null);
    }

//    @Ignore("test is not ready yet")
    @Test(expected = IOException.class)
    public void badInitFactory() throws IOException {
        AbstractFactory factory = new AbstractFactory();
        factory.init("dwq");
    }

}
