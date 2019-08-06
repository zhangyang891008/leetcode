package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;


/**
 * 仿写
 * @author Administrator
 *
 */
public class ListReverse {
	
	static List<Integer> list = new ArrayList<>();
	
	static void reverse(List list) {
		int mid = list.size()>>1;
		ListIterator<Integer> ascIterator = list.listIterator();
		ListIterator<Integer> descIterator = list.listIterator(list.size());
		for(int i = 0;i<mid;i++) {
			Integer val = ascIterator.next();
			ascIterator.set(descIterator.previous());
			descIterator.set(val);
			
		}
	}
	
	public static void main(String[] args) {
 
		Integer[] intArray = new Integer[]{1, 2, 3};
		int[] intArray2 = new int[] {2,43,5};
 
		List<Integer> list = Arrays.asList(intArray);
		List<int[]> integerList2 = Arrays.asList(intArray2);
 
		//list.sort(new NumberComparator());
		list.stream().forEach(System.out::println);
		reverse(list);
		System.out.println("***");
		list.stream().forEach(System.out::println);
	}
	
}

class NumberComparator implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1>o2?1:o1==o2?0:-1;
	}
}