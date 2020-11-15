package f0_thread;

import java.util.Random;

public class f0_5_ProducerRunnable implements Runnable{
	@Override
	public void run() {
		Random r = new Random();
		while(true)
		{
			f0_5_app.arr.add(r.nextInt(100));
		}
	}
}