package Ass4.hashMap;


import java.util.ArrayList;

public class HashLinkedList<K,V> {
	/*
	 * Fields
	 * Author: Alex Stedman -- 260627145
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
		HashNode<K,V> returnNode;
		if (size == 0) {
			return null;
		}
		if (currentNode.getKey().equals(key)) { //Checks if the head has the key value
			this.size--;
			returnNode = currentNode;
			this.head = returnNode.next;

			return returnNode;
		}
		while (currentNode.getNext() != null) { //Checks if the rest of the list has the key
			if (currentNode.getNext().getKey().equals(key)) {
				this.size--;
				returnNode = currentNode.getNext();
				currentNode.next = returnNode.getNext();
				return returnNode;
			}
			currentNode = currentNode.getNext();
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
	public String toString() {
		String output = "";
		if (size == 0) {
			return output;
		}
		HashNode<K,V> workingNode = this.head;
		while (workingNode != null) {
			output = output + workingNode.toString() + "\n";
			workingNode = workingNode.getNext();

		}
		return output;
	}

	HashNode<K,V> getFirst() {
		return this.head;
	}
	//ADD YOUR HELPER METHODS ABOVE THIS
	public ArrayList<K> keys() {
		ArrayList<K> keyList = new ArrayList<K>();
		HashNode<K,V> currentNode = this.head;
		while (currentNode != null) {
			keyList.add(currentNode.getKey());
			currentNode = currentNode.getNext();
		}
		if (keyList.size() == 0) {
			return null;
		}
		return keyList;
	}

	public ArrayList<V> values() {
		ArrayList<V> valueList = new ArrayList<V>();
		HashNode<K,V> currentNode = this.head;
		while (currentNode != null) {
			valueList.add(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
		if (valueList.size() == 0) {
			return null;
		}
		return valueList;
	}

	public HashNode<K, V> get(int element) {
		HashNode<K,V> toReturn = this.head;
		for (int i = 0; (i < element) || (i < size); i++) {
			toReturn = toReturn.getNext();
		}
		return toReturn;
	}
	public void add(HashNode<K,V> toAdd) {
		if (toAdd != null) {
			HashNode<K, V> temp = toAdd.clone();
			temp.next = this.head;
			this.head = temp;
			size++;
		}
	}
}
