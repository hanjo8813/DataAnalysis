package Philosopher;

public class Philosopher implements Runnable {

	private int pid;
	private DiningTable table;
	private String indentation;

	public Philosopher(int pid, DiningTable table) {
		this.pid = pid;
		this.table = table;
		indentation = "";
		for (int i = 0; i < pid; i++) {
			indentation += "\t\t";
		}
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(indentation + "TRY PICK");
			// 0번 철학자는 오 -> 왼 순으로 집고
			if(pid==0)
			{
				table.getLeftFork(pid);
				table.getRightFork(pid);
			} // 나머지 철학자는 왼 -> 오 순으로 집는다.
			else
			{
				table.getRightFork(pid);
				table.getLeftFork(pid);
			}
			System.out.println(indentation + "PICK");
			// 식사하고
			System.out.println(indentation + "EAT");
			// 왼 -> 오 순으로 포크를 놓는다
			table.returnLeftFork(pid);
			table.returnRightFork(pid);
			System.out.println(indentation + "RETURN");
			// Think
			System.out.println(indentation + "THINK");
		}
	}
}
