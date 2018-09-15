/**
 * File: Simulation.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */
 
public class Simulation{

	public static void main( String[] args ){
	
		int i;
		int playerwins = 0;
		int dealerwins = 0;
		int pushes = 0;
		
		for(i = 0; i < 1000; i++){
			Blackjack game = new Blackjack(); 
			game.deal();
			game.playerTurn();
			game.dealerTurn();
			
			if(game.result() == 1){
				playerwins += 1;
			}
			else if(game.result() == -1){
				dealerwins += 1;
			}
			else{
				pushes += 1;
			}
		}
		
		System.out.println("Player wins " + playerwins + " times, which is " 
		+ (playerwins* 100.0/1000) + "% of total games.");
		
		System.out.println("Dealer wins " + dealerwins + " times, which is " 
		+ (dealerwins* 100.0/1000) + "% of total games.");
		
		System.out.println("There are " + pushes + " pushes, which is " 
		+ (pushes* 100.0/1000) + "% of total games.");
		
	}
}	
