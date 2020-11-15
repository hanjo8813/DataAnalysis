package kr.ac.sejong.data_analysis.first_project;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<Email> set = new HashSet<Email>();
		// 1 3 5
		set.add(new Email(0, 1));
		set.add(new Email(0, 3));
		set.add(new Email(1, 5));

		System.out.println(set);

		System.out.println(set.contains(new Email(0, 3)));
		
	}
}
