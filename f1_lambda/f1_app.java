package f1_lambda;

public class f1_app {
	public static void func(MyFunction f)
	{
		f.calc(3, 5);
	}
	
	public static void main(String[] args) {
		MyFunction sum = (a, b) -> {
			return a+b;
		};
		func(sum);
	}
}
