package Assignment2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {

//---------------------------- 수정한 부분 ---------------------------------------

	// MyBucket이라는 클래스 자료형으로 배열 선언
	private MyBucket<E>[] buckets;
	private int prime;

	@SuppressWarnings("unchecked")
	public MyHashSet(int bucketSize) {
		prime = bucketSize;
		buckets = new MyBucket[bucketSize];
	}

	@Override
	public int size() {
		int size = 0;
		for (MyBucket<E> b : buckets) {
			if (b != null)
				size += b.getBucketList().size();
		}
		return size;
	}

	@Override
	public boolean add(E e) {
		// 해당 ID%70003에 해당하는 해시코드
		int HashCode = (int)e % prime;
		// 해시코드에 해당하는 bucketlist
		ArrayList<E> b_list = new ArrayList<E>();

		// 만약 해시코드가 존재한다면? -> 해당 해시코드의 ArrayList 중복 검사
		if (buckets[HashCode] != null) {
			b_list = buckets[HashCode].getBucketList();
			// 중복되는 ID발견!
			if (b_list.contains(e))
				return false;
			// 중복 안된다면 배열에 ID추가
			else {
				b_list.add(e);
				return true;
			}
		}
		// 해시코드가 존재하지 않는다면? -> 해당 해시코드 배열의 ArrayList에 ID추가
		b_list.add(e);
		buckets[HashCode] = new MyBucket<E>(HashCode, b_list);
		return true;
	}
	
	// buckets배열 반환 메소드 추가함
	public MyBucket<E>[] getArr() {
		return buckets;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// 복사용 배열 추가
		MyBucket<E>[] temp_buckets = new MyBucket[prime];
		// 입력받은 HashSet에서 배열만 추출하기
		MyBucket<E>[] other_buckets = ((MyHashSet) c).getArr();
		
		// 배열 크기인 prime만큼 반복하여 1차적으로 두 배열의 해시코드 비교
		for(int i=0; i<prime; i++)
		{
			// 두 배열 모두 해당 해시코드의 값을 가질때
			if(buckets[i]!=null && other_buckets[i] != null)
			{
				// 두 배열의 해당 ArrayList를 불러와서 비교 후 temp에 저장한다.
				ArrayList<E> temp_List = new ArrayList<E>();
				ArrayList<E> this_list = buckets[i].getBucketList();
				ArrayList<E> other_list = other_buckets[i].getBucketList();
				
				// 일일히 모두 비교하여 중복되는 ID만 temp_list에 저장
				for(int j=0; j<this_list.size(); j++)
				{
					for(int k=0; k<other_list.size(); k++)
					{
						// 알게된것 : 자료형 E로 선언되어있는 변수들은 비교나 계산 작업할 때 원하는 자료형으로 형 변환을 해주어야함.
						// 형 변환 안해주면 비교도 계산도 안됨 (이 사실을 몰라서 2시간 소모..)
						if((int)this_list.get(j) == (int)other_list.get(k))
						{
							temp_List.add(this_list.get(j));
							break;
						}
					}
				}
				// 위 조건을 만족하는 해시코드와 ID만을 복사 배열에 저장
				temp_buckets[i] = new MyBucket<E>(i, temp_List);
			}
		}
		buckets = temp_buckets;
		return false;
	}

//------------------------------------------------------------------------------

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

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
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
}
