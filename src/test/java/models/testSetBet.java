package models;

import org.junit.Test;

/**
 * Created by Terrance on 3/8/2016.
 */
public class testSetBet {
    @Test
    public void testSetBet(){
        Player P = new Player();
            P.setBet(100);
        AssertsNotEquals(300, P.setBet);
    }

    private void AssertsNotEquals(int i, int setBet) {
    }
}
