package com144.bitree.preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public static List<Integer> preorderTraversal(TreeNode root) {
		 List<Integer> retList = new ArrayList<>();
		 if(root == null) {
			 return retList;
		 }
		 
		 Stack<TreeNode> stack = new Stack();
		 stack.push(root);
		 
		 while(!stack.isEmpty()) {
			 TreeNode rootNode = stack.peek();
			 //System.out.println(rootNode.val);
			 retList.add(rootNode.val);
			 stack.pop();
			 if(rootNode.right != null) {
				 stack.push(rootNode.right);
			 }
			 if(rootNode.left != null) {
				 stack.push(rootNode.left);
			 }
		 }
		
		 return retList;
	        
	 }
	 
	 
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left  = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		preorderTraversal(n1);
	}

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}