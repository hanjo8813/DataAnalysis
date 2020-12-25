package f0_thread;

//무한루프의 러너블 클래스 만들기
//그 러너블의 스레드 t를 실행시키고 메인 스레드에서 t 스레드 제어하기
public class f0_2_app {
	public static void main(String[] args) throws InterruptedException {

		f0_2_PrintRunnable r = new f0_2_PrintRunnable();
		Thread t = new Thread(r);
		
		t.start();
		Thread.sleep(5000);
		
		r.setDoExit(true);
	}
}

