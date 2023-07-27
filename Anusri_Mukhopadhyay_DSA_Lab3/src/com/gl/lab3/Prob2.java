package com.gl.lab3;

import java.util.HashSet;
import java.util.Set;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Prob2 {
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob2 bst = new Prob2();
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 70);
		int targetSum = 130;
		bst.findPairWithGivenSum(bst.root, targetSum);

	}

	private void findPairWithGivenSum(Node root, int targetSum) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		if (!findPairUtility(root, targetSum, set)) {
			System.out.println("Nodes are not found.");
		}
	}

	private boolean findPairUtility(Node root, int targetSum, Set<Integer> set) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		if (findPairUtility(root.left, targetSum, set))
			return true;

		int diff = targetSum - root.data;
		if (set.contains(diff)) {
			System.err.println("Pair is (" + diff + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		return findPairUtility(root.right, targetSum, set);
	}

	private Node insert(Node node, int key) {
		// TODO Auto-generated method stub
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key < node.data) {
			node.left = insert(node.left, key);
		} else if (key > node.data) {
			node.right = insert(node.right, key);
		}
		return node;
	}

}
