package com60.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 
 * 
 * @author Administrator
 *
 */
public class Permutation {
	
	public static String getPermutation(int n, int k) {
		StringBuilder ret = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	numbers.add(i, i + 1);
        }
        Collections.reverse(numbers);
        for(int j = n; j >= 1; j--) {
        	int full = compute(j);
        	int minus = compute(j-1);
        	int curVal = full - minus;
        	int rank = 0;
        	while(k <= curVal) {
        		curVal -= minus;
        		rank ++;
        	}
        	k -= curVal;
        	ret.append(numbers.remove(rank));
        	Collections.sort(numbers);
        	Collections.reverse(numbers);
        }
        return ret.toString();
    }
	
	private static int compute(int n) {
		int ret = 1;
		while(n>1) {
			ret = ret * n;
			n--;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		String ret = getPermutation(4, 3);
		System.out.println(ret);
	}
}
