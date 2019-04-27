package com78.subset;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3] 输出: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author MZ
 *
 */
public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();

		for (int size = 0; size < nums.length+1; size++) {
			genList(nums, size, new LinkedList<Integer>(), retList, 0);
		}
		return retList;
	}
 

	private static void genList(int[] nums, int size, LinkedList linkedList, List<List<Integer>> retList, int start) {
		if (linkedList.size() == size) {
			retList.add(new LinkedList<Integer>(linkedList));
			return;
		}

		for (int i = start; i < (nums.length + linkedList.size() - size+1) &&i<nums.length; i++) {
			linkedList.add(nums[i]);
			genList(nums, size, linkedList, retList, i+1);
			linkedList.removeLast(); //如：（1,2）遍历完以后要继续遍历下一个（1,4）。所以需要将最后一个值回退
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1,2,4,3};
		List<List<Integer>> retList = SubSets.subsets(arr);
		System.out.println("test");
	}

}
