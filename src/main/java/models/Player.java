package models;

import java.util.Scanner;

/**
 * Created by nathan on 3/8/16.
 */
public class Player extends User {
    public int setBet;

    public Player()
    {
        setBet = setBet();
    }

    public static int setBet()
    {Scanner in =  new Scanner(System.in);
    System.out.print("Set a bet: ");
    int setBet = in.nextInt();
        System.out.println("You bet" + setBet);
        return setBet;
    }

    public void doubleDown(int setBet)
    {
    doubleDown(setBet * 2);
    }


    public void setBet(int i) {
    }
}

