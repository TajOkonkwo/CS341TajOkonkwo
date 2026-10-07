package okonkwo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A linked list implementation of the List interface
 * <p>Comments, documentation, and code generated in part by GitHub Copilot</p>
 * @author Taj Okonkwo
 * @version 1.0.1
 *
 * @param <E> - The type of elements in the list
 */
public class LinkedList<E> implements List<E> {
	
	// Data Members
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	// Subclasses
	/**
	 * A valued node of the list that keeps track of its previous and next element
	 * @param <N>
	 */
	private static class Node<N> {
		private N value;
		private Node<N> next;
		private Node<N> prev;
		
		/**
		 * Explicit Constructor | Create a node of a given value
		 * @param value
		 */
		public Node(N value) {
			super();
			this.value = value;
		}
		
		/**
		 * Get the node's value
		 * @return
		 */
		public N getValue() {
			return value;
		}

		/**
		 * Set the node's value
		 * @return
		 */
		public void setValue(N value) {
			this.value = value;
		}

		/**
		 * Get the node's next element
		 * @return
		 */
		public Node<N> getNext() {
			return next;
		}

		/**
		 * Set the node's next element
		 * @return
		 */
		public void setNext(Node<N> next) {
			this.next = next;
		}

		/**
		 * Get the node's previous element
		 * @return
		 */
		public Node<N> getPrev() {
			return prev;
		}

		/**
		 * Set the node's previous element
		 * @return
		 */
		public void setPrev(Node<N> prev) {
			this.prev = prev;
		}
	}

	/**
	 * An iterator for the list
	 * @param <L>
	 */
	private static class LLIterator<L> implements Iterator<L> {
		
		// Data Members
		private LinkedList<L> list;
		private Node<L> thisNode;
		
		/**
		 * Explicit Constructor | Create an iterator for the list
		 * @param list - The list over which to iterate
		 */
		public LLIterator(LinkedList<L> list) {
			this.list = list;
			this.thisNode = null;
		}

		@Override
		public boolean hasNext() {
			return (thisNode == null && list.head != null) || (thisNode != null && thisNode.getNext() != null);
		}

		@Override
		public L next() {
			// 1. If the current node is null, set it to the head of the list and return its value
			if (thisNode == null) {
				thisNode = list.head;
				return thisNode.getValue();
			}
			
			// 2. Progress the current node
			thisNode = thisNode.getNext();
			
			// 3. Return the new node's value
			return thisNode.getValue();
		}
		
	}

	
	// Constructors
	/**
	 * Default Constructor | Create an empty list
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Overrode Methods
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		// 1. Iterate through elements starting at the head
		
		// 2. If any element has the value of <o>, return true
		for (E elem: this) {
			if (elem.equals(o))
				return true;
		}
		
		// 3. If the end of the list is reached, return false
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new LLIterator<E>(this);
	}

	@Override
	public Object[] toArray() {
		// 1. Create an array of size <size>
		Object[] arr = new Object[size];
		
		// 2. Populate it with elements from the list
		for (int i = 0; i < size; i++) {
			arr[i] = get(i);
		}
		
		// 3. Return the array
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public boolean add(E e) {
		return add(new Node<E>(e));
	}

	@Override
	public boolean remove(Object o) {
		// 1. Check if the list contains the value. If not, return false
		if (!contains(o))
			return false;
		
		// 2. Search through the list for the value
		Node<E> toRemove = search(o);
		
		// 3. Relink the previous and next values to discard the node
		// 3a. Identify previous node as prev
		Node<E> prev = toRemove.getPrev();
		
		// 3b. Identify next node as next
		Node<E> next = toRemove.getNext();
		
		// 3c. Link two nodes
		if (prev != null)
			prev.setNext(next);
		if (next != null)
			next.setPrev(prev);
		
		// 4. Decrement size and return true
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object elem: c) {
			if (!contains(elem))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E elem: c) {
			add(elem);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean couldRemoveAll = true;
		for (Object elem: c) {
			boolean couldRemove = remove(elem);
			if (!couldRemove)
				couldRemoveAll = false;
		}
		return couldRemoveAll;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		return getNode(index).getValue();
	}

	@Override
	public E set(int index, E element) {
		E old = getNode(index).getValue();
		getNode(index).setValue(element);
		return old;
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public int indexOf(Object o) {
		// 1. Iterate through the list and return the index of the first element of value <o>
		int index = 0;
		for (E elem: this) {
			if (elem.equals(o))
				return index;
			index++;
		}
		
		// 2. If the end of the list is reached, return -1
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	/**
	 * Return the list as a string
	 * @return the list as a string
	 */
	@Override
	public String toString() {
		return Arrays.deepToString(toArray());
	}
	
	// Original Methods
	/**
	 * Add a new node to the end of the list
	 * @param node - The node to add
	 * @return {@code true} - The list will always be changed
	 */
	private boolean add(Node<E> node) {
		// 1. Check if the list is empty. If so, set the head and tail to this node

		// 2. Otherwise, set the tail's next element to this node and reassign the tail
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = tail.getNext();
		}
		
		// 3. Increment size
		size++;
		
		// 4. Return true because the list will always be changed
		return true;
	}
	
	/**
	 * Search the list in order until a node of value {@code o} is reached
	 * @param o - The value to find
	 * @return the first node of value {@code o}
	 * @throws NoSuchElementException - if the value couldn't be found
	 */
	private Node<E> search(Object o) {
		// 1. Start at the head
		Node<E> thisNode = head;
		
		// 2. Iterate through next values until a node of the correct value is reached. Return it.
		
		// 3. Throw an exception if no element was found
		while (true) {
			if (thisNode.getValue().equals(o))
				return thisNode;
			else if (thisNode.getNext() == null)
				throw new NoSuchElementException("Element could not be found");
			thisNode = thisNode.getNext();
		}
	}
	
	/**
	 * Get the node at an index
	 * @param index - The index of the node
	 * @return the node at the index
	 */
	private Node<E> getNode(int index) {
		// 1. Throw an exception if the index >= size or is less than 0
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("There is no element at index " + index);
		
		// 2. Start at head
		Node<E> thisNode = head;
		
		// 3. Iterate <index> number of times and set next value
		for (int i = 0; i < index; i++) {
			thisNode = thisNode.getNext();
		}
		
		// 4. Return the current node
		return thisNode;
	}

}
