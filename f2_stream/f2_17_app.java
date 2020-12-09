/*public class MySpliterator<E> implements Spliterator<E> {

	private List<E> data;
	private int idx = 0;

	public MySpliterator(List<E> data) {
		this.data = data;
	}

	@Override
	public boolean tryAdvance(Consumer<? super E> action) {
		if (idx > data.size() -1) {
			System.out.println("fail: " + idx + " at " + data);
			return false;
		}
		action.accept(data.get(idx));
		System.out.println("accept: " + data.get(idx) + " in " + data);
		idx++;
		return idx < data.size();
	}

	@Override
	public Spliterator<E> trySplit() {
		if (data.size() < 4) {
			System.out.println("trySplit(failed): " + data);
			return null;
		} else {
			int toIdx = idx + data.size() / 2;
			List<E> subList = data.subList(idx, toIdx);
			idx = toIdx;
			System.out.println("trySplit: " + data + " -> " + subList);
			return new MySpliterator(subList);
		}

	}

	@Override
	public long estimateSize() {
		System.out.println("estimateSize: " + (data.size() - idx) + " in " + data);
		return data.size() - idx;
		
		//if(data.size() - idx == 0)
		//	return 0;
		//return 1;
	}

	@SuppressWarnings("unused")
	@Override
	public int characteristics() {
		int isOrdered = Spliterator.ORDERED;
		int isDistinct = Spliterator.DISTINCT;
		int isSorted = Spliterator.SORTED;
		int isSized = Spliterator.SIZED;
		int isNonnull = Spliterator.NONNULL;
		int isImmutable = Spliterator.IMMUTABLE;
		int isConcurrent = Spliterator.CONCURRENT;
		int isSubsized = Spliterator.SUBSIZED;
		// TODO Auto-generated method stub
		return isOrdered + isSized + isSubsized;
	}

}
*/