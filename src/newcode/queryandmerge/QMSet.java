package newcode.queryandmerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**查找合并集合：集合的头结点指向自己，初始化时每个节点都独立为一个集合，每个节点的父节点默认指向自己。每次查找父节点后都指向父节点。
 * 1.判断两个节点是否属于同一个集合是通过判断他们的头结点是不是同一个。
 * 2.集合union是把两个不同的集合进行合并，合并是将集合成员少的集合合并到成员多的集合中，小集合的根节点指向大集合的根节点，集合的成员数量只需要保存到根节点中。
 * @author zhangyang891008
 *
 */

public class QMSet {
	
	public Map<Node, Node> parentMap = new HashMap<>();
	public Map<Node, Integer> sizeMap = new HashMap<>();
	
	public QMSet(List<Node> nodes){
		initSet(nodes);
	}
	
	private void initSet(List<Node> nodes) {
		for(Node node:nodes){
			parentMap.put(node, node);
			sizeMap.put(node, 1);
		}
	}

	public boolean isSameSet(Node a, Node b){
		Node parentA = getParent(a);
		Node parentB = getParent(b);
		if(parentA!=parentB){
			return false;
		}else{
			return true;
		}
	}
	
	private Node getParent(Node node){
		Node parent = parentMap.get(node);
		if(parent!=node){
			parent = getParent(parent);
		}
		if(node != parent)
			parentMap.put(node, parent);
		return parent;
	}
	
	public void union(Node a, Node b){
		Node parentA = getParent(a);
		Node parentB = getParent(b);
		if(sizeMap.get(parentA)<sizeMap.get(parentB)){
			//update the size of root
			sizeMap.put(parentB, sizeMap.get(parentA)+sizeMap.get(parentB));
			//merge set
			parentMap.put(parentA, parentB);
		}else {
			//update the size of root
			sizeMap.put(parentA, sizeMap.get(parentA)+sizeMap.get(parentB));
			//merge set
			parentMap.put(parentB, parentA);
		}
	}
	
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<>();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		QMSet set = new QMSet(nodes);
		System.out.println(set.isSameSet(node1, node2));
		set.union(node1, node2);
		System.out.println(set.isSameSet(node1, node2));
		set.union(node3, node4);
		set.union(node1, node3);
		set.isSameSet(node4, node1);
	}
}

class Node{
	int x ;
	public Node(int x){
		this.x = x;
	}
	
	public int getX(){
		return x;
	}
}

