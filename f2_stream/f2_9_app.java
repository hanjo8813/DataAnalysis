package f2_stream;

import java.util.*;
import java.util.stream.Collectors;

// 스트림의 자료형이 내가 정의한 클래스일때 정렬기준/비교기준은? (sorted)
// 이메일 데이터를 생성하고 왼쪽 기준으로 정렬해보기
public class f2_9_app {
	public static void main(String[] args) {
		ArrayList<f2_9_Email> emails = new ArrayList<f2_9_Email>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) 
		{
			emails.add(new f2_9_Email(r.nextInt(1000), r.nextInt(1000)));
		}

		// 방법1
		// 내가 만든 클래스 자료형의 어레이리스트 스트림이라서 정렬할 기준이 없다.
		// 따라서 이메일 클래스에서 정렬 기준을 정해야함.
		List<f2_9_Email> list = emails.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(list);
		
		// 방법2
		// 만약 내 클래스에서 비교기준을 정하지 않았다면? -> sorted에서 람다식으로 정의
		List<f2_9_Email> list2 = emails.stream()
				.sorted(
						(e1,e2) -> {
							if(e1.getLeft() > e2.getLeft())
								return 1;
							else if(e1.getLeft() == e2.getLeft())
								return 0;
							return -1;
						})
				.collect(Collectors.toList());
		System.out.println(list2);
	}
}
