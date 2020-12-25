package f0_thread;

import java.util.concurrent.Semaphore;

public class f0_4_app {
	public static int count = 0;
	public static Semaphore sem = new Semaphore(1);
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new f0_4_MyRunnable()).start();
		new Thread(new f0_4_MyRunnable()).start();
		new Thread(new f0_4_MyRunnable()).start();
		new Thread(new f0_4_MyRunnable()).start();
		// 스레드 동작이 너무 빨라서 메인스레드 끝나기전에 메인에 sleep 한번 걸어주자
		Thread.sleep(3000);
		System.out.println(count);
	}
}
// 전역변수 count에 스레드 여러개가 동시에 접근해서 반복문 10000번 돌리기
// 공유자원에 대한 접근의 문제점 지적 --> 세마포어로 해결