package Assignment3;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public class MyTreeSet<E> implements NavigableSet<E> {

//---------------------------- 수정한 부분 ---------------------------------------
	// 이진트리로 구현하였습니다!
	// 시작이 되는 루트노드
	private MyNode<E> root;

	@Override
	public boolean contains(Object o) {
		// 이동할 노드 포인터 생성
		MyNode<E> temp = root;
		while (true) {
			// 끝까지 와버린 경우
			if (temp == null) {
				return false;
			}
			// 새로운 데이터가 루트와 같다면? -> 중복은 허용안되니까 리턴
			if ((int) o == (int) temp.getData())
				return true;

			// 새로운 데이터가 루트보다 작다면? -> 왼쪽으로
			else if ((int) o < (int) temp.getData()) {
				temp = temp.getLeft();
			}
			// 크면? --> 오른쪽으로
			else
				temp = temp.getRight();
		}
	}

	@Override
	public boolean add(E e) {
		// 추가할 데이터가 이미 존재(중복)한다면 종료
		if (contains(e))
			return false;
		// 추가할 노드 생성
		MyNode<E> newNode = new MyNode<E>();
		newNode.setData(e);

		// 트리가 완전 비어있을 경우
		if (root == null) {
			root = newNode;
			return true;
		}

		// 이건 이동할 노드 (포인터)
		MyNode<E> temp = root;

		while (true) {
			// 새로운 데이터가 루트보다 작다면? -> 왼쪽으로
			if ((int) e < (int) temp.getData()) {
				// 끝까지 온 경우--> newNode와 부모 temp를 연결한다
				if (temp.getLeft() == null) {
					temp.setLeft(newNode);
					newNode.setParent(temp);
					return true;
				} else
					temp = temp.getLeft();
			}
			// 크면? --> 오른쪽
			else {
				// 끝까지 온 경우--> newNode와 부모 temp를 연결한다
				if (temp.getRight() == null) {
					temp.setRight(newNode);
					newNode.setParent(temp);
					return true;
				} else
					temp = temp.getRight();
			}
		}
	}

	@Override
	public E first() {
		MyNode<E> temp = root;
		// 이진탐색이므로 왼쪽으로 계속 갔을때 가장작은 값이 나온다.
		while (true) {
			if (temp.getLeft() == null)
				return temp.getData();
			temp = temp.getLeft();
		}
	}

	@Override
	public E last() {
		MyNode<E> temp = root;
		// 이진탐색이므로 오른쪽으로 계속 갔을때 가장 큰 값이 나온다.
		while (true) {
			if (temp.getRight() == null)
				return temp.getData();
			temp = temp.getRight();
		}
	}
//----------------------------------------------------------------------------

	@Override
	public Comparator<? super E> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E lower(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E ceiling(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E higher(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		// TODO Auto-generated method stub
		return null;
	}

}
