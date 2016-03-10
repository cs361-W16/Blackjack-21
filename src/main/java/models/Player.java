package models;

import java.util.ArrayList;

/**
 * Created by nathan on 3/8/16.
 */
public class Player extends User {

    //public java.util.List<Card> hand = new ArrayList<>();
    public java.util.List<Card> splithand = new ArrayList<>();
    public int bet;
    public int money;
    public int split;


    public Player(){
        money = 100;
        bet = 2;
        split = 0;
    }

    public int getBet(){
        return bet;
    }

    public int getMoney(){
        return money;
    }

    public int getSplit() { return split; }

    public void setBet(int amount){
        if(amount <= getMoney() && amount >=2) {
            bet = amount;
        }
    }

    public void setSplit(int flag){
        split = flag;
    }

    public void takeCard(Card c){
        hand.add(c);
    }

    public void takeCardSplit(Card c){
        splithand.add(c);
    }

    public void split(){
        setSplit(1);
        Card temp;

        temp = hand.get(hand.size()-1);
        splithand.add(temp);
        hand.remove(hand.size()-1);
        setBet(2 * getBet());
    }

    public void loseBet(){
        money = money - bet;
    }

    public void winBet(){
        money = money + bet;
    }

    public void doubleDown(int setBet)
    {
        money = (setBet * 2);
    }

}
