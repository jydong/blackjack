/**
 * File: Extension1.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */
 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Extension1{

	Deck deck = new Deck();
	static Hand playerHand = new Hand();
	static Hand dealerHand = new Hand();	
	
	static public void main( String[] args) {
	
		Blackjack game1 = new Blackjack(); 
		game1.deal2();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You have 200$ in your pocket, please enter the amount of money you wanna bet on this game.");
		
		int b = (scan.nextInt());
		
		System.out.println("The games begins. Here is the state of the game.");
		System.out.println(game1.toString());
		
		while(game1.playerHand.getTotalValue() <=21){
			
			System.out.println("Do you wanna draw another card? Please enter Y for yes and N for no.");
			
			String s = scan.nextLine();
	
			if(s.equals("Y")){
				game1.playerHand.add((Card)(game1.deck.deal()));
				System.out.println(game1.toString());
				
				if(game1.playerHand.getTotalValue() > 21){
					System.out.println("You lost " + b + " dollars...");
				}
				else{
					if(game1.dealerHand.getTotalValue() < 17){
						game1.dealerHand.add((Card)(game1.deck.deal()));
						System.out.println(game1.toString());
					}
					
					else if (game1.dealerHand.getTotalValue() > 21){
						System.out.println("You won " + b + " dollars!");
						break;
					}
				}
			}
	
			else if (s.equals("N")){
				if(game1.dealerHand.getTotalValue() < 17){
					game1.dealerHand.add((Card)(game1.deck.deal()));
					System.out.println(game1.toString());
					
					if(game1.dealerHand.getTotalValue() > 21){
						System.out.println("You won " + b + " dollars!");
						break;
					}
				}
	
		
				else{
					System.out.println(game1.toString());
					
					if(game1.dealerHand.getTotalValue()> game1.playerHand.getTotalValue()){
						System.out.println("You won " + b + " dollars!");	
						break;
					}
					else if(game1.playerHand.getTotalValue() > game1.dealerHand.getTotalValue()){
						System.out.println("You lost " + b + " dollars...");		
						break;	
					}
					else{
						System.out.println("It's a push!");
						break;
					}										
				}
			}	
		}
		
		System.out.println("Player: " + game1.playerHand.getTotalValue());
		System.out.println("Dealer: " + game1.dealerHand.getTotalValue());
							
	}
}