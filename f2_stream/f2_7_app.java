package f2_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class f2_7_app {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
		ArrayList<String> data = new ArrayList<String>();
		
		while (true) 
		{
			String line = br.readLine();
			if (line == null)
				break;
			data.add(line);
		}

		List<Integer> listA = data.stream()
				.filter(e -> !e.startsWith("#"))
				.map(e -> {
					String[] arr = e.split("\t");
					return new f2_Email(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
					})
				.flatMap(
						(f2_Email e) -> {
							int s = e.getSource();
							int d = e.getDestination();
							ArrayList<Integer> a = new ArrayList<Integer>();
							a.add(s);
							a.add(d);
							return a.stream();
							})
				.sorted()
				.limit(1)
				.collect(Collectors.toList());

		System.out.println(listA);
	}

}
