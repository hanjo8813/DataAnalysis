package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Assignment2App {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));

		//HashSet<Integer> leftSet = new HashSet<Integer>();
		Set<Integer> leftSet = new MyHashSet<Integer>(70003);
		//HashSet<Integer> rightSet = new HashSet<Integer>();
		Set<Integer> rightSet = new MyHashSet<Integer>(70003);

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.startsWith("#"))
				continue;

			String[] arr = line.split("\t");
			int left = Integer.parseInt(arr[0]);
			leftSet.add(left);
			int right = Integer.parseInt(arr[1]);
			rightSet.add(right);
		}
		br.close();
		System.out.println("적재끝");

		System.out.println("왼쪽 ID 갯수 : " + leftSet.size());
		System.out.println("오른쪽 ID 갯수 : " + rightSet.size());
		leftSet.retainAll(rightSet);
		System.out.println("교집합(왼쪽,오른쪽): " + leftSet.size());
	}
}