package com101.bitree.symmetric;

import java.util.Stack;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分
 
 * 
 * @author Administrator
 *
 */
public class IsSymmetric {
	
	//非递归
	public boolean isSymmetric(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			return false;
		}
 
		TreeNode leftTree = root.left;
		TreeNode rightTree = root.right;
		
		Stack<TreeNode> leftStack = new Stack();
		Stack<TreeNode> rightStack = new Stack();
		leftStack.push(leftTree);
		rightStack.push(rightTree);
		
		while(!leftStack.isEmpty() && !rightStack.isEmpty()) {
			TreeNode leftNode = leftStack.pop();
			TreeNode rightNode = rightStack.pop();
			if(leftNode.val != rightNode.val) {
				return false;
			}
			
			//put left
			if(leftNode.left != null && rightNode.right != null) {
				leftStack.push(leftNode.left);
				rightStack.push(rightNode.right);
			}
			if((leftNode.left != null && rightNode.right == null) || (leftNode.left == null && rightNode.right != null)) {
				return false;
			}
			//put right
			if(leftNode.right != null && rightNode.left != null) {
				leftStack.push(leftNode.right);
				rightStack.push(rightNode.left);
			}
			if((leftNode.right != null && rightNode.left == null) || (leftNode.right == null && rightNode.left != null)) {
				return false;
			}
		}
		
		return true;
    }
	
	//递归
	public boolean isSymmetric2(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			return false;
		}
		
		return compare(root.left, root.right);
	}
	
	private static boolean compare(TreeNode left, TreeNode right) {
		
		//叶子节点
		if(left.right == null && left.right == null && right.left == null && right.right == null) {
			if(left.val == right.val) {
				return true;
			}else {
				return false;
			}
		}
		
		boolean leftComp = false;
		boolean rightComp = false;
		
		if(left.val != right.val) {
			return false;
		}
		
		if(left.left != null && right.right != null) {
			leftComp = compare(left.left, right.right);
		}else if(left.left == null && right.right == null) {
			leftComp = true;
		}
		
		if(left.right != null && right.left != null) {
			rightComp = compare(left.right, right.left);
		}else if(left.right == null && right.left == null) {
			rightComp = true;
		}
		
		return leftComp && rightComp;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		
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