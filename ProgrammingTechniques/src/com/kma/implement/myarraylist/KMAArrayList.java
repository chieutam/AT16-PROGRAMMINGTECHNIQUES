package com.kma.implement.myarraylist;

import java.util.Collection;
import java.util.Iterator;

public class KMAArrayList<E> implements KMAList<E> {
	public static final int INITIAL_CAPACITY = 10;
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[INITIAL_CAPACITY]; // down-casting //int[] a = new int[100];
	/* So luong cua cac phan tu trong list */
	private int size = 0;

	/* Constructors */
	public KMAArrayList() {

	}

	/* Constructor with the parameters */
	public KMAArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			this.add(objects[i]);
		}

	}

	/* overidde Add method */
	@Override
	public void add(int index, E e) {
		/* 1. Kiem tra index co thoa man trong range cho phep hay khong */
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Chi so: " + index + ", Size" + this.size);
		}
		/* Change size cho mang de chuan bi insert phan tu moi vao */
		changeCapacity();
		/* 2. Di chuyen nhung phan tu o sau index */
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		/* 3. insert data */
		data[index] = e;
		/* 4. increase size len 1 don vi */
		this.size++;

	}

	private void changeCapacity() {
		if (this.size >= data.length) {
			E[] newData = (E[]) (new Object[this.size * 2]); // Mang moi ma chua co phan tu nao
			System.arraycopy(this.data, 0, newData, 0, size);
			data = newData; // tro data sang mang moi
		}

	}

	@Override
	public void clear() {
		// Cach 1
		this.data = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
		// Cach 2: loop qua this.data va set = null all size
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("index out of bound...");
		}
	}

	@Override
	public E get(int index) {
		/* check index for valid */
		checkIndex(index);
		return this.data[index];
	}

	@Override
	public int indexOf(Object e) {
		for (int i = 0; i < this.size; i++) {
			if (e.equals(this.data[i]))
				return i;
		}
		return -1; // not found
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = this.size - 1; i >= 0; i--) {
			if (e.equals(this.data[i]))
				return i;
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E o = this.data[index];// lay ra gia tri tai index

		// Duyet tu vi tri index den vi tri size - 1 va dich cac phan tu nay ve ben trai
		for (int j = index; j < this.size - 1; j++) {
			this.data[j] = this.data[j + 1];
		}
		this.data[size - 1] = null;

		this.size--;

		return o;

	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E o = this.data[index];
		this.data[index] = e; // Reference to e on heap memory....
		return o;
	}

	/* override iterator into Iterable */
	@Override
	public Iterator<E> iterator() {
		return new KMAArrayListIterator();
	}
	// inner class in java: mot lop trong mot lop

	private class KMAArrayListIterator implements Iterator<E> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			return data[currentIndex++];
		}

		public void remove() {
			if (currentIndex == 0)
				throw new IllegalStateException();
			KMAArrayList.this.remove(--currentIndex);
		}

	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(Object o) {

		return false;
	}

	@Override
	public Object[] toArray() {

		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {

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

}
