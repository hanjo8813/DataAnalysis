package f1_lambda;

public class f1_1_app {
	// 인터페이스 받는 함수
	public static void func(MyFunction f)
	{
		System.out.println(f.calc(3, 5));
	}
	
	public static void main(String[] args) {
		// 람다식으로 인터페이스 재정의
		MyFunction sum = (a, b) -> {
			return a+b;
		};
		// 재정의된 인터페이스를 변수 입력해주는 함수에 넣기
		func(sum);
	}
}
