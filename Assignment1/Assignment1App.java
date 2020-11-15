package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

public class Assignment1App {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
		ArrayList<String> data = new ArrayList<String>();
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.startsWith("#"))
				continue;
			
			data.add(line);
		}
		System.out.println("적재 끝");

		int maxLeft = Integer.MIN_VALUE;

		ListIterator<String> iterator = data.listIterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			String[] arr = line.split("\t");
			int left = Integer.parseInt(arr[0]);
			if (maxLeft < left)
				maxLeft = left;
		}

		br.close();
		System.out.println(maxLeft);

		int maxRight = Integer.MIN_VALUE;

		iterator = data.listIterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			String[] arr = line.split("\t");
			int right = Integer.parseInt(arr[1]);
			if (maxRight < right)
				maxRight = right;
		}

		System.out.println(maxRight);
	}
}