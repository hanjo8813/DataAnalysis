package f2_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//map과 flatMap 비교
public class f2_5_app {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 리스트에 1,2,3을 넣는다
		for(int i=1; i<4; i++)
		{
			list.add(i);
		}
		
		// 예제 11
		// 1. map에서 숫자당 5개로 복사후 어레이리스트에 넣고 반환 (스트림의 형이 변환됨)
		// 2. 그 어레이리스트를 collect로 리스트에 모두 담는다
		// 컬렉션의 형태를 잘 이해하고 선언하는게 중요!!
		List<ArrayList<Integer>> new_list;
		new_list = list.stream()
				.map(
						e-> {
							// 어레이리스트에 할당이 되어있어야된다. 생각해보기
							ArrayList<Integer> arr = new ArrayList<Integer>();
							for(int i=0; i<5; i++)
								arr.add(e);
							return arr;
						})
				.collect(Collectors.toList());
		System.out.println(new_list);
		
		// 예제 12
		// flatMap : map과 똑같은데 스트림의 형태가 반환되는것.
		List<Integer> new_list2 = list.stream()
				.flatMap(
						e -> {
							ArrayList<Integer> n = new ArrayList<Integer>();
							for (int i = 0; i < 5; i++)
								n.add(e);
							return n.stream();
							})
				.collect(Collectors.toList());
		System.out.println(new_list2);
	}
}
