/**
 * File: Blackjack.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */


import java.util.ArrayList;
import java.util.Random;

public class Blackjack{

	Deck deck = new Deck();
	static Hand playerHand = new Hand();
	static Hand dealerHand = new Hand();
	int bet = 0;	
	
	public Blackjack(){	 
		reset(true);
	}
	
	public void reset( boolean reshuffle){
		if(reshuffle){
			Deck freshDeck = new Deck();
			deck = freshDeck; //memory lost
			playerHand.reset();
			dealerHand.reset();
		}
	}
	
	public void deal(){
		int i;
		deck.shuffle();
		for(i = 0; i < 2; i++){
			playerHand.add((Card)(deck.deal()));
			dealerHand.add((Card)(deck.deal()));
		}
	}
	
	public void deal2(){
		int i;
		deck.shuffle();
		playerHand.add((Card)(deck.deal()));
		playerHand.add((Card)(deck.deal()));
		dealerHand.add((Card)(deck.deal()));
	}
	
	
	public String toString(){
		String state;
		
		state = "player:\n"+ playerHand.toString() + "\n" + "dealer:\n" + dealerHand.toString();
		
		return state;
	}
	
	public boolean playerTurn(){
		int i = 0;
		while(playerHand.getTotalValue() < 16){
			playerHand.add((Card)(deck.deal()));
			i++; 
		}
		if(playerHand.getTotalValue() > 21){
			return false;
		}
		else{
			return true;
		}					
	}
	
	public boolean playerTurnWithBetting(){
		int i = 0;
		while(playerHand.getTotalValue() < 16){
			playerHand.add((Card)(deck.deal()));
			i++; 
		}
		if(playerHand.getTotalValue() > 21){
			return false;
		}
		else{
			if(playerHand.getTotalValue() >= 19){
				bet = 100;
			}
			return true;
		}					
	}
	
	public boolean dealerTurn(){
		int i = 0;
		while(dealerHand.getTotalValue() < 17){
			dealerHand.add((Card)(deck.deal()));
			i++; 
		}
		if(dealerHand.getTotalValue() > 21){
			return false;
		}	
		else{
			return true;
		}					
	}
	
	public int result(){
		if(this.playerTurn()){
			if(!this.dealerTurn()){
				return 1;
			}
			else if(dealerHand.getTotalValue()> playerHand.getTotalValue()){
				return -1;	
			}
			else if(playerHand.getTotalValue() > dealerHand.getTotalValue()){
				return 1;			
			}
			else{
				return 0;
			}
		}
	
		else{
			return -1;
		}
	}		
	
	static public void main( String[] args) {
	
		Blackjack game1 = new Blackjack(); 
		game1.deal();
		game1.playerTurn();
		game1.dealerTurn();
		System.out.println(game1.toString());
	
		if(game1.playerTurn()){
			if(!game1.dealerTurn()){
				System.out.println("The player wins!");
			}
			else if(dealerHand.getTotalValue()> playerHand.getTotalValue()){
				System.out.println("The dealer wins!");	
			}
			else if(playerHand.getTotalValue() > dealerHand.getTotalValue()){
				System.out.println("The player wins!");			
			}
			else{
				System.out.println("It's a push!");
			}
		}
	
		else{
			System.out.println("The dealer wins!");
		}
		
		game1.reset(true);	
	}
}