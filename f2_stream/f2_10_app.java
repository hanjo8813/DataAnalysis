package f2_stream;

import java.util.stream.Stream;
import java.util.*;

// parallel, sequential, isParallel 
// mapToInt
public class f2_10_app {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			numbers.add(i);
		}
		// parallel, sequential : 스트림의 타입(병렬,직렬) 변환
		// isParallel : 병렬인지 참 거짓 반환
		Stream<Integer> stream = numbers.stream();
		stream.parallel();
		System.out.println(stream.isParallel());
		stream.sequential();
		System.out.println(stream.isParallel());
		
// ---------------------------------------------------------------------
		
		List<Integer> numbers2 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			numbers2.add(i);
		}
		
		// 스트림을 mapToInt로 아예 Int형으로 바꿔버린다
		// 그러면 Int 자료형의 메소드인 average 등등을 사용할 수 있게되는것.
		Double dum = numbers2.stream().mapToInt(i -> i).average().getAsDouble();
		System.out.println(dum);
		
		// Int형으로 바꾼담에 또 IntSummaryStatistics형으로 바꾼다
		// 그리고 IntSummaryStatistics형의 메소드를 사용해보기.
		IntSummaryStatistics stat = numbers2.stream().mapToInt(i -> i).summaryStatistics();
		System.out.println("AVG: " + stat.getAverage());
		System.out.println("CNT: " + stat.getCount());
		System.out.println("MAX: " + stat.getMax());
		System.out.println("MIN: " + stat.getMin());
		System.out.println("SUM: " + stat.getSum());
	}
}
