package com78.subset;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 * 
 * ˵�����⼯���ܰ����ظ����Ӽ���
 * 
 * ʾ��:
 * 
 * ����: nums = [1,2,3] ���: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
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
			linkedList.removeLast(); //�磺��1,2���������Ժ�Ҫ����������һ����1,4����������Ҫ�����һ��ֵ����
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1,2,4,3};
		List<List<Integer>> retList = SubSets.subsets(arr);
		System.out.println("test");
	}

}
