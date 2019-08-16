package com23.mergeKlist;


/**
 * 
 * 23. 合并K个排序链表
 * 
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 
 * 
 * @author Administrator
 *
 */
public class MergeKList {
	public static ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        ListNode pointer = null;
        int curVal = Integer.MAX_VALUE;
        int pos = -1;
        boolean visit = true;
        while(visit) {
        	visit = false;
        	curVal = Integer.MAX_VALUE;
        	pos = -1;
			for(int i = 0; i < lists.length; i++) {
				if(lists[i] != null) {
					visit = true;
					if(curVal > lists[i].val) {
						curVal = lists[i].val;
						pos = i;
					}
				}
			}
			if(visit) {
				if(mergedList == null) {
					mergedList = lists[pos];
					lists[pos] = lists[pos].next;
					pointer = mergedList;
					pointer.next = null;
				}else {
					pointer.next = lists[pos];
					pointer = lists[pos];
					lists[pos] = lists[pos].next;
					pointer.next = null;
				}
			}
        }
		
        return mergedList;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(6);
		ListNode[] lists = new ListNode[2];
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		lists[0] = n1;
		lists[1] = n4;
		ListNode node = mergeKLists(lists);
		System.out.println("done");
	}

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}