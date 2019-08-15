package com104.bitree.maxdepth;

import java.util.List;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 * @author Administrator
 *
 */
public class MaxDepth {
	
	public static int maxDepth(TreeNode root) {
		int depth = 0;
		depth = depth(root);
		return depth;
	}
	
	//递归方式
	private static int depth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftDepth = 0;
		if(root.left != null) {
			leftDepth = depth(root.left);
		}
		
		int rightDepth = 0;
		if(root.right != null) {
			rightDepth = depth(root.right);
		}
		
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		int retDepth = maxDepth(n1);
		System.out.println(retDepth);
	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}