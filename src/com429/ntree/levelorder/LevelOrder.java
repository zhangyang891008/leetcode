package com429.ntree.levelorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
例如，给定一个 3叉树 :
           1
      3    2   4
    5  6

返回其层序遍历:
[
     [1],
     [3,2,4],
     [5,6]
]

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。

 * @author Administrator
 *
 */
public class LevelOrder {
	
	public static List<List<Integer>> levelOrder(Node root) {
		
		List<List<Integer>> retList = new ArrayList<>();
		if(root == null) {
			return retList;
		}
		
		List<Node> list = new ArrayList<>();
		list.add(root);
		traverse(retList, list);
		
		return retList;
		
	}
	
	private static void traverse(List<List<Integer>> retList, List<Node> list) {
		List<Node> nextList = new ArrayList<>();
		List<Integer> valList = new ArrayList<>();
		if(!list.isEmpty()) {
			for(Node node : list) {
				valList.add(node.val);
				if(node.children != null) {
					for(Node child : node.children) {
						nextList.add(child);
					}
				}
			}
			
			retList.add(valList);
			traverse(retList, nextList);
		}
	}
	
	public static void main(String[] args) {
		Node n5 = new Node(5, null);
		Node n6 = new Node(6, null);
		Node n4 = new Node(4, null);
		List<Node> node3List = new ArrayList<>();
		node3List.add(n5);
		node3List.add(n6);
		Node n3 = new Node(3, node3List);
		Node n2 = new Node(2, null);
		List<Node> rootChildren = new ArrayList<>();
		rootChildren.add(n3);
		rootChildren.add(n2);
		rootChildren.add(n4);
		Node root = new Node(1, rootChildren);
		List<List<Integer>> list = levelOrder(root);
		for(List<Integer> subList : list) {
			System.out.println("***");
			for(Integer val : subList) {
				System.out.println(val);
			}
		}
	}

}

class Node {
    @Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
