package com21.mergeList;

public class MergeList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merListNode = new ListNode(520);
        ListNode pointer = merListNode;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		pointer.next = l1;
        		pointer = l1;
        		l1 = l1.next;
        		pointer.next = null;
        	}else {
        		pointer.next = l2;
        		pointer = l2;
        		l2 = l2.next;
        		pointer.next = null;
        	}
        }
		while(l1 != null) {
			pointer.next = l1;
			pointer = l1;
			l1 = l1.next;
			pointer.next = null;
		}
		while(l2 != null) {
			pointer.next = l2;
			pointer = l2;
			l2 = l2.next;
			pointer.next = null;
		}
		return merListNode.next;
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
		ListNode node = mergeTwoLists(n1,n4);
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