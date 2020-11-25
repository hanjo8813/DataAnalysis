package f2_stream;

import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Stream;

// 트리셋에서 일반 스트림과 병렬 스트림의 차이 확인
public class f2_4_app {

	public static void main(String[] args) {
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		Random r = new Random();
		for (int i = 0; i < 100000; i++) {
			numbers.add(r.nextInt(100000));
		}

		// 트리셋 스트림의 findFirst 메소드를 사용가능.
		// 사용해도 병렬 스트림과 별 차이없는 모습을 보인다.
		Stream<Integer> s = numbers.stream();
		Stream<Integer> ps = numbers.parallelStream();
		System.out.println(s.findFirst().get());
		System.out.println(ps.findFirst().get());

		// 위에서 한것과 동일
		numbers.stream().findFirst().ifPresent(e -> {
			System.out.println(e);
		});
	}
}
