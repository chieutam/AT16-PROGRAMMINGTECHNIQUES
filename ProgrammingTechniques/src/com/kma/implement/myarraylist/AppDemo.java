package com.kma.implement.myarraylist;

import java.util.Iterator;

public class AppDemo {

	public static void main(String[] args) {
		KMAArrayList<String> arrNames = new KMAArrayList<String>();

		arrNames.add("Dong");
		arrNames.add("Toc");
		arrNames.add("Hoang");
		arrNames.add("Ninh");
		arrNames.add("Thanh");
		arrNames.add("Hieu");
		arrNames.add("Khanh");
		arrNames.add("Thang");

		for (String s : arrNames) {
			System.out.println(s);
		}

		System.out.println("=======================");
		arrNames.add(2, "Dat");
		for (String s : arrNames) {
			System.out.println(s);
		}
		System.out.println("=======================");
		System.out.println(arrNames.get(3));
		System.out.println("=======================");
		arrNames.remove(3);
		for (String s : arrNames) {
			System.out.println(s);
		}
		System.out.println("=======================");
		Iterator<String> itr = arrNames.iterator(); // bo lap ben trong list

		while (itr.hasNext()) {
			System.out.println(itr.next() + "]");
		}

	}

}
