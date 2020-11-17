package f2_stream;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class f2_3_app {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 리스트에 100개의  숫자를 넣는다
		for(int i=0; i<100; i++)
		{
			list.add(i);
		}
		
		// 예제 1
		// char 형태로 변환하기
		// Stream 클래스로 선언하려면 자료형을 지정해야 하기때문에 한번에 쓴다.
		list.stream().map(
				e -> {
					return (char) ((int) e);
				}
				).forEach( e -> {
					System.out.println(e);
				});
		
		// 예제 2
		// 필터로 2의 배수만 거르고 출력하기
		Stream<Integer> s = list.stream();
		s = s.filter(
				e->{
					if(e%2==0)
						return true;
					else
						return false;
				});
		s.forEach( e -> {
			System.out.println(e);
		});
		
		System.out.println();

		// 예제 3
		// 1. 리스트의 요소에 0~100까지의 랜덤한 숫자를 추가한다
		// 2. 100이상의 수는 스트림에서 삭제 후 출력한다
		Random r = new Random();
		Stream<Integer> s2 = list.stream();
		s2 = s2.map(
				e->{
					return e + r.nextInt(101);
				});
		s2 = s2.filter(
				e->{
					if(e<100)
						return true;
					else
						return false;
				});
		s2.forEach( e -> {
			System.out.println(e);
		});
		
		// 예제 4
		// 스트림의 값을 배열에 저장하기 / Supplier와 동일. 
		// toArray 메소드 안에 원하는 (배열 자료형::new) 하면 그대로 변환된 값을 반환해줌
		Integer[] arr;
		Stream<Integer> s3 = list.stream();
		arr = s3.toArray(Integer[]::new);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}

//각종 스트림 예제들