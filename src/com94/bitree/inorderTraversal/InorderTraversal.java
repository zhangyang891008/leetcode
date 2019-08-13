package com94.bitree.inorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 
 * @author Administrator
 *
 */
public class InorderTraversal {
	
	 public static List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> retList = new ArrayList<>();
		 if(root == null) {
			 return retList;
		 }
		 
		 Stack<TreeNode> stack = new Stack();
		 stack.push(root);
		 
		 while(!stack.isEmpty()) {
			 TreeNode rootNode = stack.peek();
			 if(rootNode.left != null) {
				 stack.push(rootNode.left);
				 rootNode.left = null;  //标记访问过了
			 } else if(rootNode.right != null) {
				 //System.out.println(rootNode.val);
				 retList.add(rootNode.val);
				 stack.pop();
				 stack.push(rootNode.right);
			 } else {
				 //System.out.println(rootNode.val);
				 retList.add(rootNode.val);
				 stack.pop();
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
		inorderTraversal(n1);
	}

}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
