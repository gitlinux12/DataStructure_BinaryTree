package com.binarysearchtree;

public class BinarySearchTree<K extends Comparable <K>> {
	
	INode<K> root;
	
	public void add(K key) {
		
		this.root = this.addRecursive(root,key);
	}
	

	private INode<K> addRecursive(INode<K> root, K key) {
		if(root == null) {
			return new INode<>(key);
		}else {
			int result = key.compareTo(root.key);
			if(result == 0) return root;
			if(result < 0) {
				root.left = addRecursive(root.left, key);
			}else {
				root.right = addRecursive(root.right, key);
			}
			return root;
		}
	}
	public int getSize() {
		return this.getSizeRecursive(root);
	}
	public void preOrder() {
		System.out.println("PreOrder :");
		preOrderTraverse(root);
		System.out.println();
	}
	public void preOrderTraverse(INode<K> root) {
		if (root == null)
			return;
		System.out.println(root.key + " ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);

	}
	private int getSizeRecursive(INode<K> rootData) {
		return rootData == null ? 0 : 1 + this.getSizeRecursive(rootData.left)+this.getSizeRecursive(rootData.right);
	}
	public static void main(String args[]) {
		BinarySearchTree<Integer> binary = new BinarySearchTree<>();
	binary.add(56);
	binary.add(30);
	binary.add(70);
	
	binary.preOrder();
	int bstSize = binary.getSize();
	System.out.println("Size of binary tree is : "+bstSize);
	
	}
}
