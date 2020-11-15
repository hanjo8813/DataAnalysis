package kr.ac.sejong.data_analysis.first_project;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {

		TreeMap<Message, Integer>  map = new TreeMap<Message, Integer>();
		map.put(new Message(1,2,3l), 3);
		map.put(new Message(2,3,4l), 2);
		map.put(new Message(3,4,5l), 1);
		System.out.println(map);

	}

}
