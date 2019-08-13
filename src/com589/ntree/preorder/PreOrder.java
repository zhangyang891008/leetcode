package com589.ntree.preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :
 

返回其前序遍历: [1,3,5,6,2,4]。

           1
      3   2  4
    5   6

说明: 递归法很简单，你可以使用迭代法完成此题吗?
 
 * @author Administrator
 *
 */
public class PreOrder {
	public static List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> retList = new ArrayList<>();
        
        if(root == null) {
        	return retList;
        }
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	Node curNode = stack.peek();
        	retList.add(curNode.val);
        	stack.pop();
        	if(curNode.children != null) {
        		List<Node> childList = curNode.children;
        		for(int i = childList.size() - 1; i >= 0; i--) {
        			stack.add(childList.get(i));
        		}
        	}
        }
		return retList;
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
		List ret = preorder(root);
		ret.stream().forEach(node->{System.out.println(node);});
	}

}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}