package Motivation;

public class MyThread extends Thread {

	public char c;

	public MyThread(char c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		if (c == 'A') {
			while (true) {
				System.out.println("A");
			}
		} else {
			while (true) {
				System.out.println("\tB");
			}
		}
	}

}
