package f2_stream;

import java.util.*;

// 키 :이름 / 값:리스트 해쉬맵에서 값 리스트를 flatMap으로 매핑하기(펼치기)
public class f2_11_app {
	public static void main(String[] args) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		Random r = new Random();
		for(int i=0; i<5; i++)
		{
			ArrayList<Integer> grades = new ArrayList<Integer>();
			for(int j=0; j<5; j++)
			{
				grades.add(r.nextInt(100));
			}
			map.put(String.valueOf(i), grades);
		}
		
		// 해쉬맵 엔트리셋 스트림을 만든다
		// 엔트리셋의 값을 불러오고 -> 그걸 flatMap으로 스트림형태로 매핑
		map.entrySet().stream()
		.flatMap( e -> e.getValue().stream() )
		.forEach( e -> System.out.println(e) );
		
		// 엔트리셋의 값을 스트림 으로 불러오고 , mapToInt로 Int스트림으로 매핑.
		map.entrySet().stream()
		.flatMapToInt( e -> e.getValue().stream().mapToInt(i -> i) )
		.forEach( e -> System.out.println(e) );
	}
}
