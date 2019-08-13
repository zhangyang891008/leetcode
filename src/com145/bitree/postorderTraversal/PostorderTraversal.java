package com145.bitree.postorderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 后续遍历：
 * 
 *      a
 *    b   c
 *  d  e f g
 * 
 * 先序遍历： a b d e c f g
 * 中序遍历： d b e a f c g
 * 后序遍历： d e b f d c a
 * 
 *     a
 *   b   c
 *   pre: a b c
 *   in:  b a c
 *   post:b c a
 * 
 * @author Administrator
 *
 */

public class PostorderTraversal {
	
	public static List<Integer> postorderTraversal(TreeNode root){
		
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
			 if(rootNode.left != null) {
				 stack.push(rootNode.left);
			 }
			 if(rootNode.right != null) {
				 stack.push(rootNode.right);
			 }
		 }
		 Collections.reverse(retList);
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
		postorderTraversal(n1);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}