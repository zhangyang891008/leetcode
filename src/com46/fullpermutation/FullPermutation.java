package com46.fullpermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 
 * @author Administrator
 *
 */
public class FullPermutation {
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>(nums.length); 
        for(int i = 0;i<nums.length;i++) {
        	arr.add(nums[i]);
        }
        traverse(result, arr, 0, nums.length);
		
		return result;
    }
	
	private static void traverse(List<List<Integer>> result, List<Integer> arr, int first, int n) {
		if(first == n) {
			result.add(new ArrayList<>(arr));
		}
		for(int i = first; i<n;i++ ) {
			Collections.swap(arr, first, i);
			traverse(result, arr, first+1,n);
			Collections.swap(arr, first, i);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> ret = permute(arr);
		System.out.println("finish");
	}
}
