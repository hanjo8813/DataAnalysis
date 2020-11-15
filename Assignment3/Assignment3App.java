package Assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Assignment3App {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
		
		//NavigableSet<Integer> data = new TreeSet<Integer>();
		NavigableSet<Integer> data = new MyTreeSet<Integer>();
		
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.startsWith("#"))
				continue;
			String[] arr = line.split("\t");
			int left = Integer.parseInt(arr[0]);
			int right = Integer.parseInt(arr[1]);
			data.add(left);
			data.add(right);
		}
		System.out.println("적재끝");

		// 난이도를 낮추기 위해 이 부분은 주석처리 개인적으로 해보세요.
		// Iterator<Integer> i = data.descendingIterator();
		// while(i.hasNext()) {
		// 	System.out.println(i.next());
		// }
		
		System.out.println("가장 작은 값: " + data.first());
		System.out.println("가장 큰 값: " + data.last());
		
		System.out.println("3535가 있는가?: " + data.contains(3535));
		
		br.close();
	}
}
