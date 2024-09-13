import java.util.NoSuchElementException;

/**
 * This class provides a generic doubly linked list 
 * 
 * @author john1819
 *
 * 
 */
public class LinkedListTest<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	/*
	 * Creates an empty list.
	 */
	public LinkedListTest() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Returns a space-separated list of the elements in the list. If the list
	 * contains no elements, return an empty string ""
	 * 
	 * @return Returns a printable list of the elements in list from front to back.
	 */
	public String toString() {
		String returnString = "";
		Node<T> current = head;
		while (current != null) {
			returnString = returnString + current.data + " ";
			current = current.next;
		}
		return returnString;
	}

	/*
	 * Returns a space-separated list of the elements in the list. If the list
	 * contains no elements, return an empty string ""
	 * 
	 * @return Returns a printable list of the elements in list from back to front.
	 */
	public String toStringBackwards() {
	   // implement this method
		String returnString = "";
		Node<T> current = tail;
		while (current != null) {
			returnString = returnString + current.data + " ";
			current = current.previous;
		}
		return returnString;
	}

	/*
	 * Returns the first item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 * 
	 * @return T= returns the first element in list
	 * 
	 * @throws NoSuchElementException when list is empty
	 */
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			return head.data;
		}

	}

	/*
	 * Returns the last item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 * 
	 * @return T= returns the first element in list
	 * 
	 * @throws NoSuchElementException when list is empty
	 */
	public T getLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		} else {
			return tail.data;
		}
	}

	/*
	 * Returns the item at the specified index. If the index is not valid, throw an
	 * IndexOutOfBoundsException.
	 * 
	 * @param int index of element to be returned
	 * 
	 * @return T= returns the element of list at index
	 * 
	 * @throws NoSuchElementException when list is empty
	 */
	public T getAt(int index) {
		if (size < index) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}

	}

	/*
	 * Inserts an item at the beginning of the list.
	 * 
	 * @param T = element to be inserted
	 */
	public void insertFirst(T num) {
		// Create a new node with given data
		Node<T> new_node = new Node<T>(num);
		new_node.next = null;

		// If the Linked this is empty,
		// then make the new node as head
		if (this.head == null) {
			this.head = new_node;
			this.tail = new_node;
		} else {
			// Else add new node at beginning of the list.
			new_node.next = head;
			head.previous = new_node;
			head = new_node;

		}
		size++;

	}

	/*
	 * Inserts an item at the end of the list.
	 * 
	 * @param T - element to be inserted
	 */
	public void insertLast(T num) {
		// Create a new node with given data
		Node<T> new_node = new Node<T>(num);
		new_node.next = null;

		// If the Linked this is empty,
		// then make the new node as head
		if (this.head == null) {
			this.head = new_node;
			this.tail = new_node;
		} else {
			// Else add new node at end of the list.
			new_node.previous = tail;
			tail.next = new_node;
			tail = new_node;

		}
		size++;

	}

	/*
	 * Removes and returns the first element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 * 
	 * @return T= returns the element removed from list
	 * 
	 * @throws NoSuchElementException when list is empty
	 */
	public T removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else if (!(head == tail)) {
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		} else // head and tail are the same- one element only
		{
			T temp = head.data;
			head = head.next;
			tail = head.next;
			size--;
			return temp;
		}
	}

	/*
	 * Removes and returns the last element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 * 
	 * @return T= returns the element removed from list
	 * 
	 * @throws NoSuchElementException when list is empty
	 */
	public T removeLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		} else if (!(head == tail)) {
			T temp = tail.data;
			tail = tail.previous;
			tail.next = null;
			size--;
			return temp;
		} else // head and tail are the same- one element only
		{
			T temp = head.data;
			head = null;
			tail = null;
			size--;
			return temp;
		}
	}

	/*
	 * Returns true if the list is empty, and false otherwise.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	
	
	/**
	 * A private Node class. By making it an inner class, the outer class can access
	 * it easily, but the client cannot.
	 * 
	 * @author john1819
	 *
	 * @param <E>
	 */
	private class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> previous;

		/**
		 * Constructs a new node with the specified data
		 * 
		 * @param data
		 */
		private Node(E data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
}
