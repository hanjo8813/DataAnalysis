package f0_thread;

public class f0_5_ConsumerRunnable implements Runnable{
	@Override
	public void run() {
		while(true)
		{
			if(!f0_5_app.arr.isEmpty()) {
				System.out.println(f0_5_app.arr.remove(0));
			}
		}
	}
}