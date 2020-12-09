package f2_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Collectors의 joining 메소드 예제
public class f2_14_app {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			numbers.add(i);
		}

		// collect에서 S->A->C 트릭을 쓰지 않고 joining으로 한번에 다 붙인 문자열 반환하기
		// joining에 구분자를 입력하면 구분자가 추가된 문자열 반환.
		// joining(중간구분자, 시작 문자, 끝 문자)
		String joinedStr = numbers.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining());
		System.out.println(joinedStr);

		joinedStr = numbers.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(","));
		System.out.println(joinedStr);

		joinedStr = numbers.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining("\t"));
		System.out.println(joinedStr);

		joinedStr = numbers.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining("|", "-", "-"));
		System.out.println(joinedStr);
	}
}
