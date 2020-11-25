package f2_stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

// limit, skip, sorted, distinct 예제 실습
// Terminal Operation 종류 --> forEach, collect, count 등등..
public class f2_6_app {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 리스트에 1,2,3을 넣는다
		for(int i=1; i<1001; i++)
		{
			list.add(i);
		}
		
		// 예제 13
		// limit : 숫자를 넣으면 딱 그만큼의 요소까지 자름.
		List<Integer> new_list = list.stream()
				.limit(100)
				.collect(Collectors.toList());
		System.out.println(new_list);
		
		// 예제 14
		// skip : 입력 숫자까지 다 스킵하고 그 숫자부터 다음부터 출력.
		List<Integer> new_list2 = list.stream()
				.skip(900)
				.collect(Collectors.toList());
		System.out.println(new_list2);
		
		
		// 예제 15
		// sorted : 그냥 쓰면 스트림 요소가 정렬된다. 
		// Comparator를 활용해서 정렬기준도 설정가능.
		HashSet<Integer> hs = new HashSet<Integer>();
		Random r = new Random();
		for(int i=0; i<100; i++)
		{
			hs.add(r.nextInt(1000));
		}
		List<Integer> new_list3 = hs.stream()
				.sorted(
						(e1, e2)->{
							if(e1>e2)
								return 1;
							else if(e1==e2)
								return 0;
							else
								return -1;
						})
				.collect(Collectors.toList());
		System.out.println(new_list3);
		
		// 예제 16
		// distinct : stream 요소의 중복제거
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int i=0; i<100; i++)
		{
			list2.add(i);
		}
		List<Integer> new_list4 = list2.stream()
				.map(e -> e%5)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(new_list4);

		
	}

}
