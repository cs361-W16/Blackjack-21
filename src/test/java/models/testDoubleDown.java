package models;

import org.eclipse.jetty.server.Authentication;
import org.junit.Test;

/**
 * Created by Terrance on 3/8/2016.
 */
public class testDoubleDown {
    @Test
    public void testDoubleDown(){
        Player P = new Player();
            P.setBet(100);
            P.doubleDown(50);
        AssertNotEquals(250, P.setBet);
    }

    private void AssertNotEquals(int i, int setBet) {
    }

}
