package com.practice.array;

/**
 * ThreeLinesList
 * 
 * val previous next are used to record value preNode and nextNode.
 * free is used to statistic the space not be used.
 * 
 * 
 * @author zhangyang891008
 *
 */

public class ThreeLinesList {
	
	int size;
	int[] val = null;
	int[] previous;
	int[] next;
	
	int free = -1;
	int use = -1;
	
	public ThreeLinesList(int size) {
		if(size<0 || size ==0) {
			System.out.println("init failed! size:"+size);
			return ;
		}
		this.size = size;
		
		val = new int[size];
		for(int i =0;i<size;i++) {
			val[i] = -1;
		}
		
		previous = new int[size];
		for(int i = 0;i<size;i++) {
			//first node has no preNode
			if(i == 0) 
				previous[i] = -1;
			else 
				previous[i] = i-1;
		}
		
		next = new int[size];
		for(int i = 0;i<size;i++) {
			//the last node has no nextNode;
			if(i==size-1) 
				next[i] = -1;
			else 
				next[i] = i+1; 
		}
		free = 0;
	}
	
	public int addNode(int value) {
		if(free==-1) {
			System.out.println("add faild, free:"+free);
			return -1;
		}
		
		//给当前free头节点赋值
		int temp = free;
		val[temp] = value;
		
		// use->next->pre = cur
		if(use!=-1) {
			previous[use] = temp;			
		}
		
		//free = free -> next;
		free = next[free];
		//
		next[temp]=use;
		use = temp;
		
		//free = free->next
		if(free >-1)
			previous[free] = -1;
		return 1;
	}
	
	public void delete(int val) {
		
	}
	
	public void check() {
		//print previous
		System.out.print("previous: ");
		for(int i = 0 ;i<size;i++) {
			System.out.print((previous[i]>-1?previous[i]:"/")+"   *   ");
		}
		
		System.out.println();
		
		//print
		System.out.print("  value: ");
		for(int i = 0 ;i<size;i++) {
			System.out.print((val[i]==-1?"nil":val[i])+"   *  ");
		}
		System.out.println();
		//print next
		
		System.out.print("   next: ");
		for(int i = 0 ;i<size;i++) {
			System.out.print((next[i]>-1?next[i]:"/")+"    *  ");
		}
		System.out.println();
		
		//print free
		System.out.print("   free: ");
		int pos = free;
		while(pos!=-1) {
			System.out.print(pos+"---");
			pos = next[pos];
		}
		System.out.println();
		
		
		//print use
		System.out.print("   use: ");
		int posUse = use;
		while(posUse!=-1) {
			System.out.print(posUse+"---");
			posUse = next[posUse];
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		ThreeLinesList list = new ThreeLinesList(4);
		list.check();
		list.addNode(88);
		System.out.println("******");
		list.check();
		list.addNode(77);
		System.out.println("******");
		list.check();
		list.addNode(66);
		System.out.println("******");
		list.check();
		list.addNode(55);
		System.out.println("******");
		list.check();
		list.addNode(44);
	}
 
}
