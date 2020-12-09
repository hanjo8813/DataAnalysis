package f2_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// 등장횟수.. 구하기??
public class f2_13_app {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			list.add(line);
		}
		
		// 0	1
		HashMap<Integer, Integer> occ = list.stream()
				.filter(e -> !e.startsWith("#"))
				.flatMap(e -> { return Arrays.stream(e.split("\t"));} )
				.map(e -> Integer.parseInt(e))
				.collect(
						() -> { return new HashMap<Integer, Integer>();},
						
						(HashMap<Integer, Integer> base, Integer delta) -> 
						{
							if (base.containsKey(delta))
								base.put(delta, base.get(delta) + 1);
							else
								base.put(delta, 1);
						}, 
						// <1, 3> <2, 5> < 3, 4> partial1
						// <2, 3> <4, 7>		partial2
						// <1,3><2,8>,<3,4><4,7> partial1
						(HashMap<Integer, Integer> partial1, HashMap<Integer, Integer> partial2) -> 
						{
							partial2.forEach(
									(key, value) -> 
									{
										partial1.merge(key, value, (v1, v2) -> v1 + v2);
									});
						});
		
		occ.entrySet().forEach(System.out::println);
	}
}
