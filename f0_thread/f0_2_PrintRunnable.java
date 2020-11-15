package f0_thread;

public class f0_2_PrintRunnable implements Runnable {
	public boolean doExit = false;

	public void setDoExit(boolean doExit) {
		this.doExit = doExit;
	}

	@Override
	public void run() {
		while (!doExit) {
			System.out.println("A");
		}
	}
}