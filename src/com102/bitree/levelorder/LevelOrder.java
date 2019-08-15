package com102.bitree.levelorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 * 
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 * @author Administrator
 *
 */
public class LevelOrder {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		
		if(root == null) {
			return retList;
		}
		
		List<TreeNode> nodeList = new ArrayList<>();
		nodeList.add(root);
		levelTraverse(retList, nodeList);
	
		return retList;
	}
	
	private static void levelTraverse(List<List<Integer>> retList, List<TreeNode> list) {
		if(list.size() > 0) {
			List<TreeNode> nextLevel = new ArrayList<>();
			List<Integer> valList = new ArrayList<>();
			for(TreeNode curNode : list) {
				valList.add(curNode.val);
				if(curNode.left != null) {
					nextLevel.add(curNode.left);
				}
				if(curNode.right != null) {
					nextLevel.add(curNode.right);
				}
			}
			retList.add(valList);
			levelTraverse(retList, nextLevel);
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
		List<List<Integer>> retList = levelOrder(n1);
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
