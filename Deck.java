/**
 * File: Deck.java
 * Author: Jingyan Dong
 * Date: 09/18/2016
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{

	ArrayList<Object> deckList = new ArrayList<Object>();
	
	public Deck(){
		this.build();	 
	}
	
	public void build(){
		int i;
		int j;
		for(i = 1; i < 10; i++){
			Card newCard =  new Card(i);
			for(j = 0; j< 4; j++){
				deckList.add(newCard);
			}
		}
		
		for(i = 0; i < 16; i++){
			Card newCard = new Card(10);
			deckList.add(newCard);
		}
	}
		
		
	public Card deal(){	
		Card removed = (Card)(deckList.get(0));	
		deckList.remove(0);
		return removed;		
	}
	
	public Card pick( int i){
		Card removed = (Card)(deckList.get(i));	
		deckList.remove(i);
		return removed;
	}
		
	public void shuffle(){
	
		Random random = new Random(System.currentTimeMillis());

		Deck pickDeck = new Deck();
		 
		int i;
		int j;	 
		for(i = 0; i < 52; i++){
			j = random.nextInt(52-i);
			Card newCard = pickDeck.pick(j);
			this.deckList.set(i, newCard); //memory lost
		}		
	}
	
	
	public String toString(){
		int i;
		String content = "" ; 
		
		for (i = 0; i < deckList.size(); i++){
			Card nextCard = (Card)(deckList.get(i));
			int nextValue = nextCard.getValue();		

			content += ("card" + (i+1) + ":" + nextValue + "\n");
		} 
		
		return content;
		
	}
		
	public static void main( String[] args ){
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();		
		System.out.println(deck1.toString());
		
		deck1.deal();
		System.out.println(deck1.toString());
		
		deck1.pick(3);
		System.out.println(deck1.toString());

		deck2.shuffle();
		System.out.println(deck2.toString());		
		
	}
}