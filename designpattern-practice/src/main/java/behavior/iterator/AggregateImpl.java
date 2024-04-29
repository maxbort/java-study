package behavior.iterator;

public class AggregateImpl<E> implements Aggregate<E> {

	private E[] datas = null;
	
	public AggregateImpl(E[] datas) {
		this.datas = datas;
	
	}
	
	@Override
	public Iterator<E> createIterator() {
		return new IteratorImpl();
		
	}
	
	private class IteratorImpl implements Iterator<E> {
		int index = 0;
		
		@Override
		public E next() {
			return datas[index++];
		}
		
		@Override
		public boolean hasNext() {
			return index < datas.length;
		}
	}

}
