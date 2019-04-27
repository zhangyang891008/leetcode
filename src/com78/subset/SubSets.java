package com78.subset;

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
			genList(nums, size, new ArrayList(), retList, 0);
		}
		return retList;
	}

	private static void genList(int[] nums, int size, ArrayList arrayList, List<List<Integer>> retList, int start) {
		if (arrayList.size() == size) {
			retList.add(arrayList);
		}

		for (int i = start; i < nums.length + arrayList.size() - size+1 &&i<nums.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(arrayList);
			temp.add(nums[i]);
			genList(nums, size, temp, retList, start+1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1,3};
		List<List<Integer>> retList = SubSets.subsets(arr);
		System.out.println("test");
	}

}
