package Assignment3;

public class MyNode<E> {	
	private E data;
	private MyNode<E> left;
	private MyNode<E> right;
	private MyNode<E> parent;
		
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public MyNode<E> getLeft() {
		return left;
	}
	public void setLeft(MyNode<E> left) {
		this.left = left;
	}
	public MyNode<E> getRight() {
		return right;
	}
	public void setRight(MyNode<E> right) {
		this.right = right;
	}
	public MyNode<E> getParent() {
		return parent;
	}
	public void setParent(MyNode<E> parent) {
		this.parent = parent;
	}	
}
