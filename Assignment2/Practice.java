package Assignment2;

import java.util.ArrayList;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		
		MyHashSet<Integer> Set1 = new MyHashSet<Integer>(70003);
		MyHashSet<Integer> Set2 = new MyHashSet<Integer>(70003);
		
		for(int i=0; i<1000; i++)
			Set1.add(i);
		
		for(int i=0; i<1200; i++)
			Set2.add(i);
		
		
		Set1.retainAll(Set2);
		System.out.println(Set1.size());
	}
}
