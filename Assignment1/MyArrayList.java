package Assignment1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{
	
//------------------------------- 수정한 부분 --------------------------------
	
	private Object[] data;
	private int last_index=0;
	
	// 생성자. Object 자료형의 data 배열을 0으로 초기화 해준다.
	public MyArrayList()
	{
		data = new Object[last_index];
	}

	@Override
	// 값 하나만 입력해도 배열에 추가될 수 있게 해주는 메소드 > 결국엔 아래 add가 넣는다..
	// 이 메소드 없애면 클래스 자체에 문제가 생긴다. 이미 정해진 형식인듯함.
	public boolean add(E e) {
		add(last_index, e);
		return true;
	}
	
	@Override
	public void add(int index, E element) {
		// 맨처음 넣을때 배열 길이가 0일 경우엔 배열을 하나 늘려준다.
		if(data.length ==0)
		{
			Object[] temp = new Object[1];
			data = temp;
		}
		// 마지막 인덱스가 배열의 크기라면?? 공간이 부족한것. >> ArrayDoubling으로 해결
		// 크기가 두배인 빈 배열을 만들고 기존 배열을 복사한다. 그리고 복사본을 원본에 덮어씌운다
		if(index == data.length)
		{
			Object[] temp = new Object[data.length*2];
			for(int i=0; i<data.length; i++)
				temp[i] = data[i];
			data = temp;
		}
		
		// 마지막 인덱스에 값을 넣는다
		data[index] = element;
		
		// 그리고 다음을 위해 마지막 인덱스 +1
		last_index++;
	}
	
	@Override
	// 배열의 모든 값을 출력해주는 Arrays.toString 메소드 사용
	public String toString() {
		return Arrays.toString(data);
	}
	
	@Override
	public ListIterator<E> listIterator() {
		// 질문1 : 그냥 메소드 안에서는 오버라이딩이 안되는데 왜 return new 하고나서는 가능한가요?
		return new ListIterator<E>() 
		{
			// 다음 인덱스를 저장하는 변수 선언
			public int next_index = 0;
			
			// next_index는 next()에서 +1이 되므로 hasNext 검사할때엔 다음 인덱스가 된다.
			@Override
			public boolean hasNext() {
				if(data[next_index] != null)
					return true;
				else
					return false;
			}
			
			// 다음 인덱스인 next_index에 해당하는 data value를 반환한다
			// 그리고 나서 next_index를 +1 해준다. (코딩은 return 때문에 구조적으로 뒤바꿔서함.
			@Override
			public E next() {
				next_index+=1;
				//빨간줄이 뜨는데 실행은 됩니다.. 캐스팅 했는데 왜그런지 모르겠습니다.
				return (E) data[next_index-1];	
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public E previous() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void remove() {
				// TODO Auto-generated method stub
			}
			@Override
			public void set(E e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void add(E e) {
				// TODO Auto-generated method stub
			}
		};
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		if(data == null)
			return true;
		if(data.length == 0)
			return true;
		return false;
	}
	
	@Override
	public int size() {
		return data.length;
	}

//------------------------------- 수정한 부분 끝 --------------------------------
	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
