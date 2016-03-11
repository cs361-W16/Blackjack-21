package models;

/**
 * Created by nathan on 3/10/16.
 */
public class Game {
    public Player player;
    public Dealer dealer;
    public int winner;
    public int stayFlag;

    public Game(){
        player = new Player();
        dealer = new Dealer();
        stayFlag = 0;
    }

    public void Hit(char hand){
        if(hand == '1'){
            player.takeCard(dealer.deck.deal());
        }
        else if(hand == '2'){
            player.takeCardSplit(dealer.deck.deal());
        }
    }

    public void SplitPlayerHand(){
        player.split();
    }

    public void Stay(){
        dealer.play();
        stayFlag = 1;
    }

    public void Logic() {
        //Checks splithand against dealer
        if(player.split == 1){
            if(player.calculateScore(player.splithand) > 21){
                player.loseBet();
                winner = 2; // winner dealer
            }
            else if((dealer.calculateScore(dealer.hand) > 21) && stayFlag == 1){
                player.winBet();
                winner = 1; // winner player
            }
            else if((player.calculateScore(player.splithand) > dealer.calculateScore(player.hand)) && stayFlag == 1){
                player.winBet();
                winner = 1; // winner player
            }
            else if((player.calculateScore(player.splithand) < dealer.calculateScore(dealer.hand)) && (stayFlag == 1)){
                player.loseBet();
                winner = 2; // winner dealer
            }
            else if(player.calculateScore(player.splithand) == 21){
                player.winBet();
                winner = 1; // winner player
            }
            else if(player.calculateScore(player.splithand) == dealer.calculateScore(dealer.hand) && (stayFlag == 1)){
                player.winBet();
                winner = 1; // winner player
            }
        }

        //checks hand against dealer
        if(player.calculateScore(player.hand) > 21){
            player.loseBet();
            winner = 2; // winner dealer
        }
        else if((dealer.calculateScore(dealer.hand) > 21) && stayFlag == 1){
            player.winBet();
            winner = 1; // winner player
        }
        else if((player.calculateScore(player.hand) > dealer.calculateScore(dealer.hand)) && stayFlag == 1){
            player.winBet();
            winner = 1; // winner player
        }
        else if((player.calculateScore(player.hand) < dealer.calculateScore(dealer.hand)) && (stayFlag == 1)){
            player.loseBet();
            winner = 2; // winner dealer
        }
        else if(player.calculateScore(player.hand) == 21){
            player.winBet();
            winner = 1; // winner player
        }
        else if(player.calculateScore(player.hand) == dealer.calculateScore(dealer.hand) && (stayFlag == 1)){
            player.winBet();
            winner = 1; // winner player
        }
        // no winner
    }

    public void NewRound() {
        player.split = 0;
        stayFlag = 0;
        winner = 0;
        player.hand.clear();
        player.splithand.clear();
        dealer.hand.clear();
        for(int i = 0; i < 2; i++) {
            player.takeCard(dealer.deck.deal());
            dealer.takeCard(dealer.deck.deal());
        }
    }
}
