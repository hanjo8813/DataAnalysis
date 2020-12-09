package f2_stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Collector의 그룹화 메소드
// groupingBy, partitioningBy
// mapping, filtering
public class f2_15_app {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			numbers.add(r.nextInt(5));
		}
		
		// groupingBy(키 설정, 값 설정, 합치기)
		// Default 반환값은 Map<키 자료형, 원소 리스트>이다.
		// 람다식(S)의 결과값이 Key값이 되고 Key값을 만족하는 e를 모두 그루핑한다고 생각하자
		// Function.identity() 는 e->e 와 동일.
		// mapping(원소 값 자체, 계산할 형태) : 반환값은 컬렉터
		// filtering(bool 값, 계산할 형태) : 반환값은 컬렉터
		
		// 1
		// 키 원소당 스트림의 원소를 모두 그루핑하기
		System.out.println(numbers.stream()
				.collect(Collectors.groupingBy(e->e)));
		System.out.println(numbers.stream()
				.collect(Collectors.groupingBy(Function.identity())));
		
		// 2
		// Email 클래스를 이용해서 그루핑 해보기
		// k는 오른쪽값, v는 오른쪽에 k가 있는 모든 Email
		List<f2_9_Email> eList = new ArrayList<f2_9_Email>();
		eList.add(new f2_9_Email(1,2));
		eList.add(new f2_9_Email(2,2));
		Map<Integer, List<f2_9_Email>> m = eList.stream()
				.collect(Collectors.groupingBy(
						e-> e.getRight()
						));
		System.out.println(m);
		Map<f2_9_Email, List<f2_9_Email>> m2 = eList.stream()
				.collect(Collectors.groupingBy(
						e-> e
						));
		System.out.println(m2);

		
// -------------------------------------------------------------------------
		List<Integer> numbers2 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			numbers2.add(r.nextInt(100));
		}
		
		// 3
		// 스트림 원소를 5로 나눈 나머지를 Key로, 그에 해당하는 원소 리스트를 Value로 저장하기
		Map<Integer, List<Integer>> map = numbers2.stream()
				.collect(Collectors.groupingBy(e->e%5));
		map.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 4
		// groupingBy는 built-in 컬렉터 형태를 입력 받는다.
		// mapping(원소 값 자체, 매핑할 형태)
		System.out.println(numbers2.stream()
				.collect(Collectors.groupingBy(
						e -> e%5, 
						Collectors.mapping(Function.identity(), Collectors.counting())
						)));
		System.out.println(numbers2.stream()
				.collect(Collectors.groupingBy(
						e -> e%5, 
						Collectors.mapping(Function.identity(), Collectors.averagingDouble(e -> e))
						)));
		System.out.println(numbers2.stream()
				.collect(Collectors.groupingBy(
						e -> e%5,
						// 이렇게 줄일수도 있음.
						Collectors.summarizingDouble(e->e)
						)));
		System.out.println();

		// 5
		// filtering(bool 값, 매핑할 형태)
		// key값은 원소의 4로 나눈 나머지, value는 해당 홀수 key를 만족하는 원소의 등장횟수 구하기
		System.out.println("필터링 : " + numbers2.stream()
				.collect(Collectors.groupingBy(
						// e를 나머지로 바꾼다..
						e -> e % 4, 
						// key가 홀수라면? -> 해당 원소의 등장횟수 카운팅.
						Collectors.filtering(e -> e % 2 == 1, Collectors.counting())
						)));
		System.out.println();

		// 6
		// key는 나머지, value는 해당key 만족 원소의 등장횟수구해서 TreeMap으로 반환하기
		TreeMap<Integer, Long> tm = numbers2.stream()
				.collect(Collectors.groupingBy(
						//Classifier
						e -> e % 4, 
						//mapFactory 
						//TreeMap::new,
						() -> new TreeMap<Integer, Long>(),
						//downstream
						Collectors.mapping(Function.identity(), Collectors.counting())
						));
		System.out.println("트리맵 : " + tm);
		
		// 7 
		// groupingBy : 여러개의 그룹이 존재 가능
		// partitioningBy : T,F 두개 그룹만 존재
		// key는 bool값, 그리고 키값에 대해서 카운팅해서 맵에 저장.
		Map<Boolean, Long> map2 = numbers2.stream()
				.collect(Collectors.partitioningBy(
						e->e % 2 == 1,
						Collectors.counting()
						));
		System.out.println("partitioningBy : " +map2);
	}
}
