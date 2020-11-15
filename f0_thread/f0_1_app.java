package f0_thread;

public class f0_1_app {
	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("A");
				// 현재 스레드의 상태를 확인하기.
				System.out.println(Thread.currentThread().getState().name());
			}
		});

		// 자동으로 이름과 ID가 지정됨.
		System.out.println(t.getName());
		System.out.println(t.getId());
		// 이름 바꾸기
		t.setName("T1");
		System.out.println(t.getId());
		// t 스레드의 상태->상태의이름 출력하기
		System.out.println(t.getState().name());

		t.start();
		// 메인과 t스레드의 우선순위 출력하기
		System.out.println("main : " + Thread.currentThread().getPriority());
		System.out.println("t : " + t.getPriority());
		// 모든 스레드 2초간 정지
		Thread.sleep(2000);
		System.out.println(t.getState().name());
	}
}

//Thread-0
//14
//14
//NEW
//main : 5
//t : 5
//A
//RUNNABLE
//TERMINATED
//
//스레드 기본 메소드