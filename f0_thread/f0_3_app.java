package f0_thread;

public class f0_3_app {
	public static void main(String[] args) throws InterruptedException {
		f0_3_PrintRunnable r = new f0_3_PrintRunnable();
		Thread t = new Thread(r);
		
		t.start();
		Thread.sleep(2000);
		
		t.interrupt();
	}
}

// 스레드에 인터럽트 거는 조건 : sleep을 만난다면 바로 발동된다
//1. 메인 스레드에서 인터럽트 실행  
//2. t스레드의 run 메소드에서 sleep을 만남
//3. 바로 exception으로 catch되어 반복문 종료됨