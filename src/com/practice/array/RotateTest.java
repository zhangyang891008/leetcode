package com.practice.array;

import java.util.Arrays;
import java.util.List;

public class RotateTest {
	
	public static void main(String[] args) {
		List<Character> list = Arrays.asList('a','b','c','d','e');
		rotate(list, 2);
		list.stream().forEach(System.out::println);
	}
	
    private static void rotate(List<Character> list, int distance) {
    	int size = list.size();
        if (size == 0)
            return;
        distance = distance % size;
        if (distance < 0)
            distance += size;
        if (distance == 0)
            return;

        //为什么nMoved作为判断循环退出的条件？
        for (int cycleStart = 0, nMoved = 0; nMoved != size; cycleStart++) {
        	Character displaced = list.get(cycleStart);
            int i = cycleStart;
            do {
                i += distance;
                if (i >= size)
                    i -= size;
                displaced = list.set(i, displaced);
                nMoved ++;
                
                
    System.out.print("current list: ");
    list.stream().forEach(System.out::print);
    System.out.println();
    
            } while (i != cycleStart);
        }
	}
    
    private static void rotate2(List<Character> list, int distance) {
    	int size = list.size();
        if (size == 0)
            return;
        distance = distance % size;
        if (distance < 0)
            distance += size;
        if (distance == 0)
            return;

        //为什么nMoved作为判断循环退出的条件？
        for (int cycleStart = 0; cycleStart<distance ; cycleStart++) {
        	Character displaced = list.get(cycleStart);
            int i = cycleStart;
            do {
                i += distance;
                if (i >= size)
                    i -= size;
                displaced = list.set(i, displaced);
 
            } while (i != cycleStart);
        }
	}
 

}
