package com.datastruct.tree;

import java.util.Scanner;

class Node {
	Integer data;
	Node left;
	Node right;

	Node() {
		data = null;
		left = null;
		right = null;
	}
}

class BinaryTree {
	Node head;
	Scanner input = new Scanner(System.in);
	static Scanner in = new Scanner(System.in);

	BinaryTree() {
		head = null;
	}

	public void createNode(Node temp, Node newNode) {
		if (head == null) {
			System.out.println("This is the root");
			head = newNode;
			return;
		}

		if (temp == null)
			temp = head;

		System.out
				.println("Press 'l' or 'r' to insert left or of " + temp.data);
		char inputVal = input.next().charAt(0);
		if (inputVal == 'l') {
			if (temp.left == null) {
				temp.left = newNode;
				System.out
						.println("Value inserted to the left of " + temp.data);
			} else {
				System.out.println("Value occupied by " + temp.left.data);
				createNode(temp.left, newNode);
			}
		} else if (inputVal == 'r') {
			if (temp.right == null) {
				temp.right = newNode;
				System.out.println("Value inserted to the right of "
						+ temp.data);
				return;
			} else {
				System.out.println("Value occupied by " + temp.right.data);
				createNode(temp.right, newNode);
			}
		} else {
			System.out.println("Invalid input; Please try again");
			return;
		}
	}

	public void print() {
		inorder(head);
	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		} else
			return;
	}

	public static void main(String args[]) {
		BinaryTree treeObj = new BinaryTree();
		int choice = 0;
		do {
			System.out.println("1. Insert \t 2. Search \t3. Print");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				Node newNode = new Node();
				newNode.data = getData();
				newNode.left = null;
				newNode.right = null;
				treeObj.createNode(treeObj.head, newNode);
				break;
			case 2:
				break;
			case 3:
				System.out.println("Inorder Traversal of Tree ::");
				treeObj.print();
				break;
			default:
				return;
			}
		} while (true);

	}

	public static Integer getData() {
		System.out.println("Enter the value to insert: ");
		return (Integer) in.nextInt();
	}
}