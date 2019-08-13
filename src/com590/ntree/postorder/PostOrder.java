package com590.ntree.postorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

          1
      3   2  4
    5   6

返回其后序遍历: [5,6,3,2,4,1].
 * @author Administrator
 *
 */
public class PostOrder {
	public static List<Integer> postorder(Node root) {
		
		List<Integer> retList = new ArrayList<>();
		
		if(root == null) {
			return retList;
		}
		
		traverse(retList, root);
		Collections.reverse(retList);
		return retList;
    }
	
	private static void traverse(List<Integer> retList, Node node) {
		if(node != null) {
			retList.add(node.val);
		}
		if(node.children != null) {
			List<Node> childList = node.children;
			for(int i = childList.size() - 1; i >= 0; i--) {
				traverse(retList, childList.get(i));
			}
		}
	}
	
	
	//非递归
	public static List<Integer> postorder2(Node root) {
		
		List<Integer> retList = new ArrayList<>();
		
		if(root == null) {
			return retList;
		}
		
		Stack<Node> stack = new Stack();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Node curNode = stack.peek();
			retList.add(curNode.val);
			stack.pop();
			if(curNode.children != null) {
				List<Node> childList = curNode.children;
				for(Node child : childList) {
					stack.push(child);
				}
			}
		}
 
		Collections.reverse(retList);
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
		List ret = postorder(root);
		ret.stream().forEach(node->{System.out.println(node);});
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