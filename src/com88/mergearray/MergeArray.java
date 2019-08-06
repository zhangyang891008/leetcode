package com88.mergearray;

/**88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 
 *
 */

public class MergeArray {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        int posM = m - 1;
        int posN = n - 1;
        for(int i = size - 1; i >= 0; i--) {
        	if(posM >= 0 && posN >= 0) {
        		if(nums1[posM] > nums2[posN]) {
        			nums1[i] = nums1[posM--];
        		}else {
        			nums1[i] = nums2[posN--];
        		}
        	}else if(posM >= 0) {
        		nums1[i] = nums1[posM--];
        	}else {
        		nums1[i] = nums2[posN--];
        	}
        	
        }
    }
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,7,0,0,0};
		int[] arr2 = {1};
		merge(arr1,3,arr2,1);
		System.out.println("finish");
	}

}
