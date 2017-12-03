package Ass4.hashMap;


public class HashLinkedList<K,V>{
	/*
	 * Fields
	 */
	private HashNode<K,V> head;

	private Integer size;

	/*
	 * Constructor
	 */

	HashLinkedList(){
		head = null;
		size = 0;
	}


	/*
	 *Add (Hash)node at the front of the linked list
	 */

	public void add(K key, V value){
		// ADD CODE BELOW HERE
		HashNode<K,V> temp = new HashNode<K,V>(key, value);
		temp.next = head;
		this.head = temp;
		size = size + 1;
		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){
		// ADD CODE BELOW HERE
		HashNode<K,V> currentNode = this.head;
		while (currentNode.next != null) {
			if (currentNode.getKey().equals(key)) {
				return currentNode;
			}
			else {
				currentNode = currentNode.next;
			}
		}
		if (currentNode.getKey().equals(key)) {
			return currentNode;
		}
		return null;
		// ADD CODE ABOVE HERE
	}


	/*
	 * Remove the head node of the list
	 * Note: Used by remove method and next method of hash table Iterator
	 */

	public HashNode<K,V> removeFirst(){
		// ADD CODE BELOW HERE
		if (size == 0) {
			return null;
		}
		HashNode<K,V> currentNode = this.head;
		this.head = currentNode.next;
		if (size > 0) {
			size = size - 1;
		}
		// ADD CODE ABOVE HERE
		return currentNode; //CODE STUB.. REMOVE THIS LINE
	}

	/*
	 * Remove Node by key from linked list 
	 */

	public HashNode<K,V> remove(K key){
		// ADD CODE BELOW HERE
		HashNode<K,V> currentNode = this.head;
		while (currentNode.getNext().next != null) {
			if (currentNode.getNext().getKey().equals(key)) {

			}
		}
		// ADD CODE ABOVE HERE
		return null; // removing failed
	}



	/*
	 * Delete the whole linked list
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * Check if the list is empty
	 */

	boolean isEmpty(){
		return size == 0? true:false;
	}

	int size(){
		return this.size;
	}

	//ADD YOUR HELPER  METHODS BELOW THIS


	//ADD YOUR HELPER METHODS ABOVE THIS


}
