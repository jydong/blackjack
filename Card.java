/**
 * File: Card.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */

import java.util.ArrayList;
import java.util.Random;

public class Card{

	private int value;
	
	public Card(int v){
		if(v >= 1 && v <= 10){
			value = v;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main( String[] args ){
		
		Card card1 =  new Card(7);
		Card card2 =  new Card(14);
		
		if (card1.getValue() >= 1 && card1.getValue() <= 10){
			System.out.println(card1.getValue());
		}
		
		else{
			System.out.println("invalid value given");
		}
			
		if (card2.getValue() >= 1 && card2.getValue() <= 10){
			System.out.println(card2.getValue());
		}
		
		else{
			System.out.println("invalid value given");
		}
	}
}
	
	
		