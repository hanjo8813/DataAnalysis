package f2_stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f2_1_app {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i=0; i<100; i++) {
			numbers.add(i);
		}
		// 스트림은 파이프라인 구조
		Stream<Integer> s = numbers.stream();
		
		// Predicate
		// filter는  내가 정한 기준(람다식으로 정의)에 맞춰 스트림을 필터링한다
		// 스트림의 인자를 바꾸지 않고 필터링. -> 필터링된 스트림 반환
		s = s.filter(
				(e)->{
					if(e%2==0)
						return true;
					return false;
				}
				);
		// Function
		// map은 스트림의 인자를 하나하나 내가 정한 기준(람다식)으로 가공한다.
		// 가공된 스트림을 반환
		s = s.map(
				(e) -> { return e*3; }
				);
		
		// Supplier
		// collect는 collectors의 변환 메소드를 사용한다
		// ex) Collectors.toList()를 넣으면 리스트로 변환됨.
		// collectors의 toCollection 람다식으로 정의해야한다.(어떤 컬렉션으로 변환할지)
		// 스트림의 인자를 정해진 자료형에 넣은 후 변환된 자료형을 반환함.
		HashSet<Integer> hs;
		hs = s.collect(Collectors.toCollection(
				()->{ return new HashSet<Integer>(); }
				)
				);
		System.out.println(hs);
		// Consumer
		// 스트림의 인자를 내가 정한 식(람다식)에 따라 모두 소비한다.
		// 스트림의 인자를 모두 돌려서 한번 쓰면 스트림에서 삭제되는 구조. -> 수행시 스트림 clear
		// 아래는 e -> { System.out.println(e); } 을 넣은것과 동일
		//s.forEach( System.out::println );
	}
}

// 스트림 메소드 filter, map, collect, forEach 실습
//0~99 배열을 스트림에 넣고 각 요소의 짝수만 3배하고 그 스트림을 hashset 구조로 바꾸기
//또는 가공된 배열을 모두 출력하기
