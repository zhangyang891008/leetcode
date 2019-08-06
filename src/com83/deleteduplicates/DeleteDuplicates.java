package com83.deleteduplicates;

/**83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 
 * @author Administrator
 *
 */
public class DeleteDuplicates {
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		int tempVal = head.val;
		//ListNode p = head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur!=null) {
			if(tempVal == cur.val) {
				pre.next = cur.next;
				cur = cur.next;
			}else {
				tempVal = cur.val;
				pre = cur;
				cur = cur.next;
			}
		}
        
		return head;
    }
	
	public static void main(String[] args) {
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
