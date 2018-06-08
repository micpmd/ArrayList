package arraylist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public ArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#size()
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#get(int)
	 */
	@Override
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size "
					+ index);
		}
		return (T) elements[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#set(int, java.lang.Object)
	 */
	@Override
	public void set(int index, T item) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size "
					+ index);
		}

		elements[index] = item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#add(java.lang.Object)
	 */
	@Override
	public void add(T item) {
		if (this.size == elements.length) {
			ensureCapa();
		}
		elements[this.size++] = item;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#insert(int, java.lang.Object)
	 */
	@Override
	public void insert(int index, T item) {
		if (this.size == elements.length) {
			ensureCapa();
		}
		for (int i = this.size; i > index; i--) {	
			elements[i] = elements[i-1];
		}
		this.size++;
		elements[index] = item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#insertFirst(java.lang.Object)
	 */
	@Override
	public void insertFirst(T item) {
		if (this.size == elements.length) {
			ensureCapa();
		}
		for (int i = this.size; i > 0; i--) {	
			elements[i] = elements[i-1];
		}
		this.size++;
		elements[0] = item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#remove(int)
	 */
	@Override
	public T remove(int index) {
		T res = (T) elements[index];
		for (int i = index + 1; i < this.size; i++) {
			elements[i - 1] = elements[i];
		}
		this.size--;
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#removeFirst()
	 */
	@Override
	public T removeFirst() {
		T res = (T) elements[0];

		for (int i = 1; i < this.size; i++) {
			elements[i - 1] = elements[i];
		}
		this.size--;
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#subList(int, int)
	 */
	@Override
	public List<T> subList(int start, int end) {
		ArrayList<T> res = new ArrayList<>();
		for (int i = start; i < end; i++) {
			res.add(this.get(i));
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#subList(int)
	 */
	@Override
	public List<T> subList(int index) {
		ArrayList<T> res = new ArrayList<>();
		for (int i = index; i < this.size; i++) {
			res.add(this.get(i));
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#add(arraylist.List)
	 */
	@Override
	public void add(List<T> other) {
		for (int i = 0; i < other.size(); i++) {
			this.add(other.get(i));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arraylist.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(T item) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String res = "[ ";
		for (int i = 0; i < this.size; i++) {
			res = res + elements[i] + " ";
		}
		return res + "]";
	};
}
