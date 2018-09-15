/**
 * File: Extension2.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */
 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; 

public class Extension2{

	public static void main( String[] args ){
	
		int i;
		int playerWins = 0;
		int dealerWins = 0;
		int pushes = 0;
		int bet = 0;
		int playerMoney = 0;
		
		for(i = 0; i < 1000; i++){
			Blackjack game = new Blackjack(); 
			game.deal();
			game.playerTurnWithBetting();
			game.dealerTurn();
			
			if(game.result() == 1){
				playerWins += 1;
				playerMoney += game.bet;
			}
			else if(game.result() == -1){
				dealerWins += 1;
				playerMoney -= game.bet;
			}
			else{
				pushes += 1;
				
			}
		}
		
		
		System.out.println("Player wins " + playerWins + " times, which is " 
		+ (playerWins* 100.0/1000) + "% of total games.");
		
		System.out.println("Player wins " + playerMoney + " dollars.");
		
		System.out.println("Dealer wins " + dealerWins + " times, which is " 
		+ (dealerWins* 100.0/1000) + "% of total games.");
		
		System.out.println("There are " + pushes + " pushes, which is " 
		+ (pushes* 100.0/1000) + "% of total games.");
		
	}
}	
