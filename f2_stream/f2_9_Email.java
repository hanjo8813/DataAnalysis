package f2_stream;

public class f2_9_Email implements Comparable<f2_9_Email> {
	private int left;
	private int right;

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public f2_9_Email(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}

	// 비교 기준을 정해준다. 
	// sorted에서 Comparator를 사용하기에 반환값을 -1,0,1로 정한것.
	@Override
	public int compareTo(f2_9_Email o) {
		if(this.left > o.left)
			return 1;
		else if(this.left == o.left)
			return 0;
		return -1;
	}
	// 출력 형태 오버라이딩
	@Override
	public String toString() {
		return left + "->" + right;
	}
}


