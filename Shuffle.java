/**
 * File: Shuffle.java
 * Author: Jingyan Dong
 * Date: 09/13/2016
 */

import java.util.ArrayList;
import java.util.Random;

public class Shuffle{

	public static void main( String[] args ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random random = new Random();

		int i;
		int r;
		for (i = 0; i < 10; i++){
			r = random.nextInt(100);
			list.add(r);
			System.out.println(r);	
			System.out.println(list.get(i));			
		}
		
		for (i = 0; i < 10; i++){
			int j;
			j = random.nextInt(10-i);
			int removed = j;
			list.remove(removed);
			System.out.print(removed);
			System.out.println(list);
									
		}
				
		for (i = 1; i < 11; i++){
			list.add(i);
			System.out.println(i);	
		}
		
	
		for (i = 0; i < 10; i++){
			r = random.nextInt(100);
			list.add(r);		
		}
		
		
		
	}
}