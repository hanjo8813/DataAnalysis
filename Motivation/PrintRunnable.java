package Motivation;

public class PrintRunnable implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
			Thread.sleep(1000);
			System.out.println("A");
			}catch(InterruptedException e) {
				break;
			}
		}
		System.out.println("끝");
	}
}