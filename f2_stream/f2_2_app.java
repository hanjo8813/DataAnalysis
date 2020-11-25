package f2_stream;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

//스트림 메소드 reduce, max, min 실습
public class f2_2_app {
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 리스트에 100개의 랜덤 숫자를 넣는다
		for(int i=0; i<100; i++)
		{
			list.add(r.nextInt(100));
		}
		
		// BinaryOperator
		// 람다식 : 입력 - 인자 e1 e2 / 출력 - 둘 중에 큰값
		// reduce : 입력 - 인자 하나 / 출력 - 그 인자 출력 >>> 두개받고 하나는 삭제
		Stream<Integer> s = list.stream();
		int max = s.reduce(
				(e1,e2)-> {
					if(e1> e2)
						return e1;
					else
						return e2;
				}
				).get();
		System.out.println(max);

		// Comparator
		// 람다식 : 입력 - left, right / 출력 - 1 0 -1
		// max : 입력 - 1 0 -1 / 출력 - 1, 0일때 람다식 입력값의 왼쪽값, -1 일땐 오른쪽 값
		Stream<Integer> s2 = list.stream();
		int max2 = s2.max(
				(left, right) ->{
					if(left > right)
						return 1;
					else if (left==right)
						return 0;
					else
						return -1;
				}
				).get();
		System.out.println(max2);
		
		// 람다식 : 입력 - left, right / 출력 - 1 0 -1
		// min : 입력 - 1 0 -1  / 출력 : 1 0 일땐 람다식 입력값의 오른쪽값 ,-1 일땐 왼쪽값
		Stream<Integer> s3 = list.stream();
		int min = s3.min(
				(left, right) ->{
					if(left > right)
						return 1;
					else if (left==right)
						return 0;
					else
						return -1;
				}
				).get();
		System.out.println(min);
	}
}


