package com27.removeelement;

/**27. 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。
 * @author zy
 *
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        //int size = nums.length;
		if(nums.length==0)
            return 0;
        int start = 0;
        int end = nums.length-1;
        while(start< end) {
        	if(nums[start]!=val) {
        		start++;
        	}else {
        		if(nums[end]==val) {
        			end--;
        		}else {
        			swap(nums,start,end--);
        		}
        	}
        }
        int size = (nums[start]==val)?start:(start+1);
        return size;
    }
	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	public static void main(String[] args) {
		int arr[] = {0,0,1,2,0,1};
		int val = 0;
		int ret = removeElement(arr,val);
		System.out.println(ret);
	}

}
