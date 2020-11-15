package f0_thread;

public class f0_4_MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10000; i++)
		{
			try {
				f0_4_app.sem.acquire();	//임계구역 접근 허가
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f0_4_app.count++;
			f0_4_app.sem.release();  // 임계구역 빠져나왔다고 알리기
		}
	}
}