package myStore;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class ArrayList<E extends Comparable<E>> {

	public static final int CAPACITY = 1000;
	private int size = 0;
	private E[] arr;

	public ArrayList(int capacity) {
		arr = (E[]) new Comparable[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Nhập sai số thứ tự: " + i);
	}

	public int sizeOfArray() {
		return size;
	}

	public E get(int i) {
		return arr[i];

	}

	public void addLast(E e) {
		arr[size] = e;
		size++;
	}

	public void addInIndex(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		checkIndex(i, size + 1);
		if (size == arr.length) {
		throw new IllegalStateException("Danh sách đã đầy. Không thêm được.");
		}
		for (int k = size - 1; k >= i; k--) {
			arr[k + 1] = arr[k];
		}
		arr[i] = e;
		size++;
	}

	public void remove(int i) {
		for (int k = i; k < size - 1; k++)
			arr[k] = arr[k + 1];
		arr[size - 1] = null;
		size--;
	}

	public void remove(E e) {
		int i = 0;
		while (i < size) {
			if (arr[i].equals(e))
				remove(i);
			i++;
		}
	}
	
	
	public void removeAll() {
		int i = 0;
		while (i < size) {
			remove(i);
			i--;
		}
		i++;
	}

	public void hoanVi(int a, int b) {
		E min = arr[a];
		arr[a] = arr[b];
		arr[b] = min;
	}

	public void quickSort(int left, int right, Comparator<E> c) {
		int mid = (left + right) / 2;
		E pivot = arr[mid];
		int i = left, j = right;
		if (i >= j)
			return;
		while (i <= j) {

			while (c.compare(arr[i], pivot) < 0) {
				i++;
			}

			while (c.compare(arr[j], pivot) > 0) {
				j--;
			}
			if (i <= j) {
				hoanVi(i, j);
				i++;
				j--;
			}
		}
		quickSort(left, j, c);
		quickSort(i, right, c);

	}

	@Override
	public String toString() {
		String result = "";
		for (E e : arr)
			result += e + "\n";
		return result;
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		int cursor;
		int lastRet = -1;

		ListIterator() {
		}

		public boolean hasNext() {
			return cursor != size;
		}

		public E next() {
			int i = cursor;
			if (i >= size)
				throw new NoSuchElementException();
			E[] data = ArrayList.this.arr;
			if (i >= data.length)
				throw new ConcurrentModificationException();
			cursor = i + 1;
			return data[lastRet = i];
		}

		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();

			try {
				ArrayList.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}

	
}
