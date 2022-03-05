package com.kma.implement.mylinkedlist;

import java.util.Collection;
import java.util.Iterator;

public class KMALinkedList<E> extends KMAAbstractList<E> {
	// 1. define all data fields
	private Node<E> head, tail; // head và tail để trỏ tới vùng null
	// 2. constructor

	public KMALinkedList() {

	}

	public KMALinkedList(E[] objects) {
		super(objects);
	}

	// 3. Định nghĩa các methods cần thiết
	/* 3.1. Lấy ra phần tử đầu tiên của LinkedList */
	public E getFirst() {
		if (this.size == 0) {
			return null;
		} else {
			return this.head.element;
		}
	}

	/* 3.2. Lấy ra phần tử cuối cùng */
	public E getLast() {
		if (this.size == 0) {
			return null;
		} else {
			return this.tail.element;
		}
	}

	/* Thêm 1 node vào vị trí đầu tiên của KMALinkedList */
	public void addFirst(E e) {
		// Tạo ra node để thêm vào vị trí đầu tiên
		Node<E> newNode = new Node<E>(e); // element not null and next -> null
		newNode.next = head;
		this.head = newNode;
		this.size++;
		if (this.tail == null) // ban đầu chưa có phần tử nào.
			this.tail = head;
	}

	/* Thêm 1 node vào vị trí cuối cùng của LinkedList */
	public void addLast(E e) {
		// tạo ra node mới
		Node<E> newNode = new Node<E>(e);
		if (this.tail == null) {
			this.head = this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = this.tail.next;// null

		}
		this.size++;
	}

	/* Thêm 1 data vào một vị trí index bất kỳ */
	public void add(int index, E e) {

		if (index == 0) {
			this.addFirst(e);
		} else if (index >= this.size) {
			this.addLast(e);
		} else {
			// định nghĩa current
			Node<E> current = this.head;
			// Duyệt từ head đến vị trí của index
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			// định nghĩa newNode và cho current.next trỏ tới
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			this.size++;

		}

	}

	// inner class => de tao ra cau truc cua NODE:
	private static class Node<E> {
		E element; // data ""
		Node<E> next; // Để chứa địa chỉ của phần tử tiếp theo (tạo ra liên kế động giữa các element
						// bên trong LinkedList

		public Node(E e) {
			this.element = e;
		}

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.head = this.tail = null;

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
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		StringBuilder r = new StringBuilder("[");// [1,3,4,5]
		Node<E> current = this.head;
		for (int i = 0; i < this.size; i++) {
			r.append(current.element);
			current = current.next;
			if (current != null) {
				r.append(",");
			} else {
				r.append("]");
			}
		}

		return r.toString();

	}

}
