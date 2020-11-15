package kr.ac.sejong.data_analysis.first_project;

public class Email {
	private int left;
	private int right;

	public Email(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}
	
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
	
	@Override
	public int hashCode() {
		return left + right;
	}
	@Override
	public boolean equals(Object another) {
		if (this.left == ((Email) another).left && this.right == ((Email) another).right)
			return true;
		else
			return false;
	}
	@Override
	public String toString() {
		return "(" + left + "," + right + ")";
	}

}
