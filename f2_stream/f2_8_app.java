package f2_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// anyMatch, peek, takeWhile, dropWhile, onClose 예제 
public class f2_8_app {
	public static void main(String[] args){

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=0; i<100; i++)
		{
			numbers.add(i);
		}
		
		// 예제 1 : anyMatch
		// 조건문(람다식)에 해당하는 값이 스트림에 하나라도 존재한다면 True 반환.
		// Short Circuit evaluation -> 병렬수행하다가 조건값이 나타나면 바로 종료됨.
		// Terminal Operation 이다. --> noneMatch, allMatch 등등..
		boolean isAllOver100 = numbers.stream()
				.anyMatch(e->e<0);
		System.out.println(isAllOver100);
		
		// 예제 2 : peek
		// forEach는 TO라서 한번 출력하면 다신 스트림을 못씀.
		// peek은 출력 하고나서도 계속 사용가능.
		List<Integer> list1 = numbers.stream()
				.peek(e -> System.out.println(e))
				.map(e -> e*3)
				.collect(Collectors.toList());
		System.out.println(list1);
		
		// 예제3  : takeWhile
		// 조건의 범위에 해당하는 값을 모두 저장한다. 0~69 저장
		List<Integer> list2 = numbers.stream()
				.takeWhile( e-> e<70)
				.collect(Collectors.toList());
		System.out.println(list2);
		
		// 예제4  : dropWhile
		// 조건의 범위에 해당하는 값을 모두 버린다. 0~69 버림
		List<Integer> list3 = numbers.stream()
				.dropWhile( e-> e<70)
				.collect(Collectors.toList());
		System.out.println(list3);
		
// ---------------------------------------------------------------------
		
		List<Integer> numbers2 = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			numbers2.add(i);
		}
		// 1. TO가 등장할때까지 출력되는 것은 없다. TO를 만나는 순간 위쪽 파이프라인의 순서가 실행된다.
		// 2. TO인 collect를 거치고 peek에서 스트림원소 하나를 출력.
		// 3. 그리고 list까지 출력해도 onClose는 동작 X
		// 4. 스트림을 close 시키고 나서야 x가 출력됨.
		Stream<Integer> stream = numbers2.stream();
		List<Integer> list4 = stream
				.onClose(() -> {System.out.println("x");})
				.peek(e -> {System.out.println(e);})
				.collect(Collectors.toList());

		System.out.println(list4);
		stream.close();
	}
}
