package com82.deleteduplicates;


/**82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 
 * @author Administrator
 *
 */
public class DeleteDuplicates {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode newList = head;
		ListNode preList = newList;
		int tempVal = head.val;
		int count = 1;
		int sum = 0;
		ListNode cur = head.next;
		while(cur!=null) {
			if(tempVal == cur.val) {
				cur = cur.next;
				count++;
			}else {
				if(count == 1) {
					newList.val = tempVal;
					preList = newList;
					newList = newList.next;
					sum++;
				}
				tempVal = cur.val;
				cur = cur.next;
				count = 1;
			}
		}
		if(count == 1) {
			newList.val = tempVal;
			newList.next = null;
			sum++;
		}else {
			preList.next = null;
		}
		return sum == 0 ? null : head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new  ListNode(1);
 
		head.next = n1;
 
		ListNode retNode = deleteDuplicates(head);
		System.out.println("finish");

	}
	
	public static void test1() {
		ListNode head = new ListNode(0);
		ListNode n1 = new  ListNode(0);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode retNode = deleteDuplicates(head);
		System.out.println("finish");
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}