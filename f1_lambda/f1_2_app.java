package f1_lambda;

//러너블 인터페이스에 람다함수 사용해서 run 정의하기
public class f1_2_app {
	public static void main(String[] args) {
		// 기존 방식대로 쓰기
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<100; i++)
				{
					System.out.println(i);
				}
			}
		}).start();
		
		// 러너블을 람다 표현식으로 쓰기
		Runnable r = () -> {
			for(int i =0; i<100; i++)
			{
				System.out.println(i);

			}
		};
		new Thread(r).start();
		
		// 러너블 따로 선언 안하고 스레드 안에 바로 람다 표현식으로 쓰기
		new Thread( () -> {
			for(int i =0; i<100; i++)
			{
				System.out.println(i);

			}
			}).start();
	}
}

