package com142.detectcycle;

/**142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
 * @author zy
 *
 */
public class DetectCycle {
	public static ListNode detectCycle(ListNode head) {
		if(head==null || head.next ==null) {
			return null;
		}
		ListNode fast = head;
        ListNode slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			/**
			 * 假设链表的起始节点为 A，环的入口节点为 B，两个指针（快慢指针）相交节点为 C，AB 两点之间的长度为 x，BC 两点之间的长度为 y， 
			 * CB 两点之间的长度为 z。慢指针 slow 走过的长度为 x+y， 快指针 fast 为了“赶上”慢指针，应该走过的长度为 x+y+z+y， 
			 * 同时，由于快指针的速度是慢指针的两倍，因此相同时间内，快指针走过的路程应该是慢指针（走过的路程）的两倍. '''
			 * 因此 x == z 所以slow从头head开始走x和fast再往前走z就可以在环的起始出相遇
			 */
			if(slow == fast){  
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
				
		}
		return null;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		ListNode retNode = detectCycle(node1);
		System.out.println("finish");
	}
}
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
        val = x;
        next = null;
	}
}