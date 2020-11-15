package f0_thread;

import java.util.ArrayList;

public class f0_5_app {
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
		
	public static void main(String[] args) throws InterruptedException {
		new Thread(new f0_5_ProducerRunnable()).start();
		new Thread(new f0_5_ConsumerRunnable()).start();
	}
}
// 생산자-소비자 문제