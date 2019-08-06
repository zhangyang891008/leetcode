package com119.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
 
 * @author Administrator
 *
 */
public class Triangle {
	public static List<Integer> getRow(int rowIndex) {

		if(rowIndex == 0) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			return list;
		}
		
        int[] numbers = new int[rowIndex+1];
        for(int i = 0; i < rowIndex; i++) {
        	numbers[i] = 0;
        }
        numbers[0] = 1;
        numbers[1] = 1;
        int posMax = 2;
        while(posMax <= rowIndex) {
        	int previous = 1;
        	int current = 1;
	        for(int j = 1; j < posMax; j++) {
	        	current = numbers[j];
	        	numbers[j] = previous + current;
	        	previous = current;
	        }
	        numbers[posMax] = 1;
        	posMax++;
        }
        
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
        	ret.add(numbers[i]);
        }
		return ret;
    }
	public static void main(String[] args) {
		List ret = getRow(2);
		System.out.println("finish");
	}

}
