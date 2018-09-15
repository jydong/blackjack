/**
 * File: Extension3.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */
 
import java.util.ArrayList; 
import java.util.*;
import java.util.Scanner; 

public class Extension3{
	
	public ArrayList<Integer> list = new ArrayList<Integer>();
	
	
	public Extension3(ArrayList<Integer> list){
		this.list = list;	
	}


	public int getSum(){
		int sum = 0;
		int i;
		for (i = 0; i < this.list.size(); i++){
			int value= this.list.get(i);
			sum += value;
		} 
		
		return sum;
		
	}
	
	public double getMean(){			
		double mean = (double)(this.getSum()/ (this.list.size()* 1.0));
		return mean;
	}
	
	public double getSD(){
		double sum = 0;
		double mean = this.getMean();
		for(int i= 0; i < this.list.size(); i++){
			sum += (Math.pow((this.list.get(i) - mean),2));
		}	
		return Math.sqrt(sum / this.list.size());
	}
	

	public static void main( String[] args ){
		int i;
		int j;
		int playerwins = 0;
		int dealerwins = 0;
		int pushes = 0;
			
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many games do you want for the simulation?");
		int T = (int)(scan.nextInt());
		
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		
		
		for (i = 0; i < T; i++){
			playerwins = 0;
			dealerwins = 0;
			pushes = 0;
		
			for(j = 0; j < 100; j++){
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
			
			list1.add(playerwins);
			list2.add(dealerwins);
			list3.add(pushes);	
		}
		
		Extension3 SD1 = new Extension3(list1);
		Extension3 SD2 = new Extension3(list2);
		Extension3 SD3 = new Extension3(list3);
		
		double sd1, sd2, sd3;
		sd1 = SD1.getSD();
		sd2 = SD2.getSD();
		sd3 = SD3.getSD();
		
		System.out.println(sd1);
		System.out.println(sd2);
		System.out.println(sd3);
		
		
	}
		
}	