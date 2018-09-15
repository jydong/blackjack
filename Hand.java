/**
 * File: Hand.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */

import java.util.ArrayList;
import java.util.Random;

public class Hand{
	
	public Hand(){
		ArrayList<Object> list = new ArrayList<Object>();
	}
	
	public void reset(){
		list.clear(); //memory lost
	}
	
	public void add( Card card ){
		list.add(card);		
	}
		
	public int size(){
		return list.size();
	}
	
	public Card getCard(int i){
		return (Card)(list.get(i));
	}
	
	public int getTotalValue(){
		int sum = 0;
		for (int i = 0; i < list.size(); i++){
			Card nextCard = (Card)(list.get(i));
			int nextValue = nextCard.getValue();
			
			sum += nextValue;
		} 
		return sum;
	}
	
	
	public String toString(){
		int i;
		String content = "" ; 
		
		for (i = 0; i < list.size(); i++){
			Card nextCard = (Card)(list.get(i));
			int nextValue = nextCard.getValue();		

			content += ("card" + (i+1) + ":" + nextValue + "\n");
		} 
		
		return content;
	}
	
	public static void main( String[] args ){
		Hand hand1 = new Hand();
		Card card1 = new Card(7);
		Card card2 = new Card(8);
		Card card3 = new Card(9);
		hand1.add(card1);
		hand1.add(card2);
		hand1.add(card3);
		
		System.out.println(hand1.toString());
		
		System.out.println(hand1.size());
		System.out.println(hand1.getCard(2));
		System.out.println(hand1.getTotalValue());
		
		hand1.reset();
		System.out.println(hand1.toString());
		
		
	}
	
}