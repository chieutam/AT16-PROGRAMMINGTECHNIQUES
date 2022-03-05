package com.kma.implement.mylinkedlist;

import com.kma.implement.myarraylist.KMAList;

public abstract class KMAAbstractList<E> implements KMAList<E> {
	protected int size = 0; // số lượng node (element) có được bên trong Linked

	public KMAAbstractList() {

	}

	public KMAAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			this.add(this.size, objects[i]);
		}
	}

	@Override
	public boolean add(E e) {
		this.add(size, e);
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean remove(Object e) {
		// 1. Lấy vị trí của phần tử muốn remove
		int pos = this.indexOf(e);
		if (pos >= 0) {
			this.remove(pos);
			return true;
		}

		return false;
	}
}
