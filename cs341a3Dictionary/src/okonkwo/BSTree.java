package okonkwo;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BSTree<B extends Comparable<B>> {

	// Data Members
	private Node<B> root;
	private int size;
	
	// Subclasses
	/**
	 * A node of the tree containing a value, a parent node, and left and right children
	 * @param <B>
	 */
	private static class Node<B extends Comparable<B>> {
		
		// Node - Data Members
		private B value;
		private Node<B> parent;
		private Node<B> left;
		private Node<B> right;
		
		// Node - Constructors
		// Default
		public Node() {
			new Node<B>(null);
		}
		
		// Explicit
		public Node(B value) {
			super();
			this.value = value;
		}

		// Node - Getters and Setters
		public B getValue() {return value;}
		public void setValue(B value) {this.value = value;}
		
		public Node<B> getParent() {return parent;}
		public void setParent(Node<B> parent) {this.parent = parent;}
		
		public Node<B> getLeft() {return left;}
		public void setLeft(Node<B> left) {this.left = left;}
		
		public Node<B> getRight() {return right;}
		public void setRight(Node<B> right) {this.right = right;}
		
	}
	
	// Class Exceptions
	/**
	 * Thrown when a tree needs to access an element, but the tree is empty
	 */
	private static class EmptyTreeException extends RuntimeException {
			
		public EmptyTreeException() {
			new EmptyTreeException("");
		}
		
		public EmptyTreeException(String msg) {
			super(msg);
		}
		
	}
	
	/**
	 * Thrown when trying to add a node of equal value to a pre-existing node
	 */
	private static class DuplicateNodeException extends RuntimeException {
		
		public DuplicateNodeException() {
			new DuplicateNodeException("");
		}
		
		public DuplicateNodeException(String msg) {
			super(msg);
		}
		
	}
	
	// Constructors
	public BSTree() {
		root = null;
	}
	
	// New Methods
	// Public
	/**
	 * Add a node to the tree
	 * @param value - the value of the added node
	 */
	public void add(B value) {
		// Call <add()> for an instantiated Node of value <value>
		add(new Node<B>(value), true);
	}
	
	public void remove(B value) {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	// Private
	/**
	 * Add a node to the tree
	 * @param node - the node to be added
	 * @param changeSize - Should {@code size} change after the addition?
	 * @throws DuplicateNodeException if a node of identical value already exists in the tree
	 */
	private void add(Node<B> node, boolean changeSize) {
		// 1. Check for the root. If there's no root, set it to <node> and increment size.
		
		// 2. If there is a root, keep track of it as <parent>.
		Node<B> parent;
		if (isEmpty()) {
			root = node;
			size++;
			return;
		} else {
			parent = root;
		}
		
		// 3. Compare <parent> value to that of <node>.
		// 3a. If <node> value is smaller, make <parent.left> new <parent> if not null.
		
		// 3b. If values are equal, throw DuplicateNodeException
		
		// 3c. If it's greater, make <parent.right> the new <parent> if not null.
		
		// 4. If <parent.left> or <parent.right> is null, set those values to <node>. Make sure to set new parent.
		while (true) {
			if (node.getValue().compareTo(parent.getValue()) < 0) {
				// Search left
				if (parent.getLeft() != null)
					parent = parent.getLeft();
				else {
					parent.setLeft(node);
					break;
				}
			}
			else if (node.getValue().compareTo(parent.getValue()) == 0)
				throw new DuplicateNodeException("A value [" + node.getValue() + "] node already exists in the tree.");
			else {
				// Search right
				if (parent.getRight() != null)
					parent = parent.getRight();
				else {
					parent.setRight(node);
					break;
				}
			}
		}
		
		// 5. Increment <size>.
		if (changeSize)
			size++;
	}
	
	/**
	 * Go down tree until a node of {@code value} is found, then return the node if there is one
	 * @param value - the value of the node to be found
	 * @return the node of the same value as {@code value}
	 * @throws EmptyTreeException if searching on an empty tree
	 * @throws NoSuchElementException if a node of same value as {@code value} does not exist
	 */
	private Node<B> search(B value) {
		// 1. Keep track of the root. Set it to the variable <parent>. If root is null, throw EmptyTreeException
		if (isEmpty())
			throw new EmptyTreeException("The tree is empty, so no value can be searched for.");
		Node<B> parent = root;
		
		// 2. Compare <parent> value to <value>.
		// 2a. If <value> is smaller, make <parent.left> the new <parent> if not null.
		
		// 2b. If values are equal, return <parent>
		
		// 2c. If <value> is greater, make <parent.right> the new <parent> if not null.
		
		// 3. If <parent.left> or <parent.right> is null, throw NoSuchElementException.
		while (true) {
			if (value.compareTo(parent.getValue()) < 0) {
				// Search left
				if (parent.getLeft() != null)
					parent = parent.getLeft();
				else
					throw new NoSuchElementException("A value [" + value + "] node could not be found.");
			}
			else if (value.compareTo(parent.getValue()) == 0)
				return parent;
			else {
				// Search right
				if (parent.getRight() != null)
					parent = parent.getRight();
				else
					throw new NoSuchElementException("A value [" + value + "] node could not be found.");
			}
		}
	}
	
	// List Methods
	// Public
	public ArrayList<B> toList() {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	public int size() {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	public void clear() {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	public boolean isEmpty() {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	// Private
	private static ArrayList<?> subTreeList() {
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	// Object Methods
	
}
