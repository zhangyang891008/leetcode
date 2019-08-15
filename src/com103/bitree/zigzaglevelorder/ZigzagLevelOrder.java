package com103.bitree.zigzaglevelorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 
 * @author Administrator
 *
 */
public class ZigzagLevelOrder {
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> retList = new ArrayList<>();
		if(root == null) {
			return retList;
		}
		List<TreeNode> nodeList = new ArrayList<>();
		boolean positive = true;
		nodeList.add(root);
		zigzagTraverse(retList, nodeList, positive);
		return retList;
	}
	
	private static void zigzagTraverse(List<List<Integer>> retList, List<TreeNode> nodeList, boolean positive) {
		if(!nodeList.isEmpty()) {
			List<Integer> valList = new ArrayList<>();
			List<TreeNode> nextLevel = new ArrayList<>();
			for(TreeNode curNode : nodeList) {
				valList.add(curNode.val);
				if(curNode.left != null) {
					nextLevel.add(curNode.left);
				}
				if(curNode.right != null) {
					nextLevel.add(curNode.right);
				}
			}
			
			if(positive) {
				positive = false;
				retList.add(valList);
			}else {
				positive = true;
				Collections.reverse(valList);
				retList.add(valList);
			}
			
			zigzagTraverse(retList, nextLevel, positive);
		}
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
		List<List<Integer>> retList = zigzagLevelOrder(n1);
		System.out.println("finish");
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
