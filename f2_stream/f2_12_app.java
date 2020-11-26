package f2_stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// collect의 Supplier, Accumulator, Combiner 트릭
// Collectors 메소드의 maxBy, minBy
// 더 다양한 Collectors 메소드
public class f2_12_app {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		// 1
		// 0~9의 숫자를 스트링으로 바꾸고 다 합친 문자열을 반환하기.
		StringBuilder ret = numbers.parallelStream()
				.collect(
						// Supplier
						// StringBuilder란? -> 빈 문자열이라 생각하면됨 ("")
						() -> { return new StringBuilder(); },
						
						// Accumulator (매핑)
						// numbers 스트림의 원소는 i이다
						// i를 스트링으로 변환 후 StringBuilder("")에 추가하는것.
						(StringBuilder sb, Integer i) -> {
							sb.append(String.valueOf(i));
						}, 
						
						// Combiner
						// 두가지의 partial한 결과를 받아주는 것 (위에서 반환되는 sb)
						// 두번째로 오는 원소(sb2)를 앞의 원소(sb1)에 담는것이 원칙이다.
						(sb1, sb2) -> {
							sb1.append(sb2);
						});
		System.out.println(ret);
		
		// 2
		// 0~9의 숫자를 모두 더하기 
		AtomicInteger ret2 = numbers.parallelStream()
				.collect(
						() -> new AtomicInteger(),
						
						(AtomicInteger at, Integer i) -> {
							at.addAndGet(i);
						}, 
						
						// addAndGet -> p1 += p2 느낌
						(p1, p2) -> {
							// p1.set(p1.get() + p2.get());
							p1.addAndGet(p2.get());
						});
		System.out.println(ret2);

		// 3
		// 0~9의 숫자 중 최대값을 뽑아내기
		// Collectors 메소드의 maxBy
		// maxBy에 comparator 람다식을 입력한다.
		int max = numbers.stream()
				.collect(Collectors.maxBy(
						(e1, e2) -> {
							if (e1 > e2)
								return 1;
							else if (e1 == e2)
								return 0;
							else
								return -1;
						})).get();
		System.out.println(max);
		
		// 4
		// minBy.
		int min = numbers.stream()
				.collect(Collectors.minBy(
						(e1, e2) -> {
							if (e1 > e2)
								return 1;
							else if (e1 == e2)
								return 0;
							else
								return -1;
						})).get();
		System.out.println(min);

		// 5
		// 얘네들 반환값 Int, Long, Double로 여러가지임
		System.out.println(numbers.stream().collect(Collectors.counting()));
		System.out.println(numbers.stream().collect(Collectors.averagingDouble(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.averagingInt(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.averagingLong(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summingDouble(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summingInt(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summingLong(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summarizingDouble(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summarizingInt(e -> e)));
		System.out.println(numbers.stream().collect(Collectors.summarizingLong(e -> e)));

//		stream.collect(collector);
//		stream.collect(supplier, accumulator, combiner);
//		
//		
//		stream.reduce(accumulator);
//		stream.reduce(identity, accumulator);
//		stream.reduce(identity, accumulator, combiner);
//		

//		stream.spliterator();

	}
}
