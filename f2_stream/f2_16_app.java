package f2_stream;

import java.util.*;
import java.util.stream.Collectors;

public class f2_16_app {
	public static void main(String[] args) {
		ArrayList<f2_9_Email> list = new ArrayList<f2_9_Email>();
		list.add(new f2_9_Email(1, 2));
		list.add(new f2_9_Email(1,4));
		list.add(new f2_9_Email(1,7));
		list.add(new f2_9_Email(2, 4));
		list.add(new f2_9_Email(2,7));
		list.add(new f2_9_Email(3, 7));
		list.add(new f2_9_Email(4, 5));
		
		// toMap(키 설정, 값 설정, 합치기)
		// 합치기 할때는 
		// Default 반환값은 Map<키 자료형, 원소 리스트>이다.
		// 
		
		// 1
		// 위에서 저장된 이메일 리스트를 (왼쪽, [오른쪽 들]) 로 저장하기 (왼쪽기준)
		Map<Integer, Set<Integer>> map = list.stream()
				.collect(Collectors.toMap(
						// keyMapper
						//f2_9_Email::getLeft,
						e -> e.getLeft(),
						// valueMapper
						e -> {
							HashSet<Integer> hs = new HashSet<Integer>();
							hs.add(e.getRight());
							return hs;
							},
						// merge
						(e1, e2) -> {
							e1.addAll(e2);
							return e1;
							}));
		map.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 2
		// TreeMap으로 자료형 바꿔서 반환하기
		TreeMap<Integer, Set<Integer>> tm = list.stream()
				.collect(Collectors.toMap(
						f2_9_Email::getLeft,
						e -> {
							HashSet<Integer> hs = new HashSet<Integer>();
							hs.add(e.getRight());
							return hs;
						},
						(e1, e2) -> 
						{
							e1.addAll(e2);
							return e1;
						}, 
						TreeMap::new));
		System.out.println(tm);
		tm.entrySet().forEach(System.out::println);
		System.out.println();
		
		Map<Integer, List<Integer>> l = list.stream()
				.collect(Collectors.toMap(
						e -> e.getLeft(),
						e -> { 
							ArrayList<Integer> a = new ArrayList<Integer>();
							a.add(e.getRight());
							return a;
						},
						(e1,e2) -> {
							e1.addAll(e2);
							return e1;
						}, 
						TreeMap::new
						));
		System.out.println(l);
//----------------------------------------------------------------------

		// 3
		// reducing : 인자 2개받고 1개 반환해줌
		f2_9_Email minLeft = list.stream()
				.collect(Collectors.reducing(
						(f2_9_Email e1, f2_9_Email e2) -> {
							if(e1.getLeft() < e2.getLeft())
								return e1;
							else
								return e2;
						}
						)).get();
		System.out.println(minLeft);
		System.out.println();
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		// reducing(기본값, 인자2개->1개)
		// 0 + e1 + e2 가 반환되는거임
		int sum = list2.stream().
				collect(Collectors.reducing(
						0,
						(e1, e2) -> e1+e2
						));
		System.out.println(sum);
		System.out.println();
		
		// 1*e1*e2 가 반환되는거임
		int mul = list2.stream().
				collect(Collectors.reducing(
						1,
						(e1, e2) -> e1*e2
						));
		System.out.println(mul);
		System.out.println();
		
		// 스트림안의 리듀스 메소드
		int x = list2.stream().reduce((e1,e2) -> e1+e2).get();
		System.out.println(x);
		System.out.println();
		
		// teeing : 두개의 컬렉터를 연결시킨다
		List<Integer> sumMul = list2.stream()
				.collect(Collectors.teeing(
						Collectors.reducing((e1, e2) -> (int) e1 + (int) e2), 
						Collectors.reducing((e1, e2) -> (int) e1 * (int) e2),
						(e1, e2) -> List.of(e1.get(), e2.get())
						));
		System.out.println(sumMul);
	}
}
