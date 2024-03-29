package Ass4.hashMap;
import java.util.ArrayList;
import java.util.Iterator;
class MyHashTable<K,V> {
	/*
	 *   Number of entries in the HashTable.
	 *   Author: Alex Stedman -- 260627145
	 */
	private int entryCount = 0;
	/*
	 * Number of buckets. The constructor sets this variable to its initial value,
	 * which eventually can get changed by invoking the rehash() method.
	 */
	private int numBuckets;
	/**
	 * Threshold load factor for rehashing.
	 */
	private final double MAX_LOAD_FACTOR=0.75;
	/**
	 *  Buckets to store lists of key-value pairs.
	 *  Traditionally an array is used for the buckets and
	 *  a linked list is used for the entries within each bucket.   
	 *  We use an Arraylist rather than an array, since the former is simpler to use in Java.   
	 */
	ArrayList< HashLinkedList<K,V> >  buckets;

	/* 
	 * Constructor.
	 * 
	 * numBuckets is the initial number of buckets used by this hash table
	 */
	MyHashTable(int numBuckets) {
		//  ADD YOUR CODE BELOW HERE
		this.numBuckets = numBuckets; 
		this.buckets = new ArrayList<>(numBuckets);
		//creates new list of size buckets full of empty hashLinkedLists
		for (int i = 0; i < numBuckets; i++) {
			HashLinkedList<K,V> tempList = new HashLinkedList<K,V>();
			buckets.add(tempList);
		}
		//  ADD YOUR CODE ABOVE HERE

	}

	/**
	 * Given a key, return the bucket position for the key. 
	 */
	private int hashFunction(K key) {

		return  Math.abs( key.hashCode() ) % numBuckets ;
	}

	/**
	 * Checking if the hash table is empty.  
	 */

	public boolean isEmpty()
	{
		if (entryCount == 0)
			return true;
		else
			return(false);
	}

	/**
	 *   return the number of entries in the hash table.
	 */

	public int size()
	{
		return(entryCount);
	}

	/**
	 * Adds a key-value pair to the hash table. If the load factor goes above the 
	 * MAX_LOAD_FACTOR, then call the rehash() method after inserting. 
	 * 
	 *  If there was a previous value for the given key in this hashtable,
	 *  then overwrite it with new value and return the old value.
	 *  Otherwise return null.   
	 */

	public  V  put(K key, V value) {

		//  ADD YOUR CODE BELOW HERE
		int hashedValue = hashFunction(key);
		
		if (containsKey(key)){
			V prevValue = buckets.get(hashedValue).remove(key).getValue();
			buckets.get(hashedValue).add(key, value);
			return prevValue;
		} else{
			buckets.get(hashedValue).add(key, value);
			entryCount++;
		}
		
		double loadFactor = entryCount/ numBuckets;
		if (loadFactor > MAX_LOAD_FACTOR) rehash();
		//  ADD YOUR CODE ABOVE HERE
		return null;
	}

	/**
	 * Retrieves a value associated with some given key in the hash table.
     Returns null if the key could not be found in the hash table)
	 */
	public V get(K key) {

		//  ADD YOUR CODE BELOW HERE
		
		for (HashLinkedList<K,V> tempList: this.buckets){
			if (tempList.getListNode(key) != null){
				return tempList.getListNode(key).getValue();
			}
		}

		//  ADD YOUR CODE ABOVE HERE

		return null;
	}

	/**
	 * Removes a key-value pair from the hash table.
	 * Return value associated with the provided key.   If the key is not found, return null.
	 */
	public V remove(K key) {

		//  ADD YOUR CODE BELOW HERE
		
		for (HashLinkedList<K,V> hashList: this.buckets){
			if (hashList.getListNode(key) != null){
				entryCount--;
				return hashList.remove(key).getValue();
			}
		}

		//  ADD  YOUR CODE ABOVE HERE

		return(null);
	}

	/*
	 *  This method is used for testing rehash().  Normally one would not provide such a method. 
	 */

	public int getNumBuckets(){
		return numBuckets;
	}

	/*
	 * Returns an iterator for the hash table. 
	 */

	public MyHashTable<K, V>.HashIterator  iterator(){
		return new HashIterator();
	}

	/*
	 * Removes all the entries from the hash table, 
	 * but keeps the number of buckets intact.
	 */
	public void clear()
	{
		for (int ct = 0; ct < buckets.size(); ct++){
			this.buckets.get(ct).clear();
		}
		entryCount=0;		
	}

	/**
	 *   Create a new hash table that has twice the number of buckets.
	 */


	public void rehash()
	{
		//   ADD YOUR CODE BELOW HERE
		Iterator<HashNode<K,V>> allEntries = iterator();
		int currentEntries = entryCount;
		this.numBuckets = numBuckets*2;
		this.buckets.clear();

		//below loop inits number of hashlists according to number of buckets
		for (int i = 0; i < numBuckets; i++) {	
			HashLinkedList<K,V> newList = new HashLinkedList<>();
			this.buckets.add(newList);
		}
		
		entryCount = 0;
		
		HashNode<K,V> currentNode;
		//itterates through each node, putting into new list
		for (int i = 0; i < currentEntries; i++) {
			currentNode = allEntries.next();
			put(currentNode.getKey(), currentNode.getValue());
		}
		
		//   ADD YOUR CODE ABOVE HERE

	}


	/*
	 * Checks if the hash table contains the given key.
	 * Return true if the hash table has the specified key, and false otherwise.
	 */

	public boolean containsKey(K key)
	{
		int hashValue = hashFunction(key);
		if(buckets.get(hashValue).getListNode(key) == null){
			return false;
		}
		return true;
	}

	/*
	 * return an ArrayList of the keys in the hashtable
	 */

	public ArrayList<K>  keys()
	{

		ArrayList<K>  listKeys = new ArrayList<K>();

		//   ADD YOUR CODE BELOW HERE
		HashNode<K,V> entryNode;
		Iterator<HashNode<K,V>> fullHashList = iterator();
		//iterates through hashlist adding key for each node
		for (int i = 0; i < entryCount; i++) {
			entryNode = fullHashList.next();
			listKeys.add(entryNode.getKey());
		}
		
		return listKeys;
		//   ADD YOUR CODE ABOVE HERE

	}

	/*
	 * return an ArrayList of the values in the hashtable
	 */
	public ArrayList <V> values()
	{
		ArrayList<V>  listValues = new ArrayList<V>();

		//   ADD YOUR CODE BELOW HERE
		HashNode<K,V> entryNode;
		Iterator<HashNode<K,V>> fullHashList = iterator();
		//iterates through hashlist adding value for each node
		for (int i = 0; i < entryCount; i++) {
			entryNode = fullHashList.next();
			listValues.add(entryNode.getValue());	
		}

		return listValues;
		//   ADD YOUR CODE ABOVE HERE

	}

	@Override
	public String toString() {
		/*
		 * Implemented method. You do not need to modify.
		 */
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buckets.size(); i++) {
			sb.append("Bucket ");
			sb.append(i);
			sb.append(" has ");
			sb.append(buckets.get(i).size());
			sb.append(" entries.\n");
		}
		sb.append("There are ");
		sb.append(entryCount);
		sb.append(" entries in the hash table altogether.");
		return sb.toString();
	}

	/*
	 *    Inner class:   Iterator for the Hash Table.
	 */
	public class HashIterator implements  Iterator<HashNode<K,V> > {
		HashLinkedList<K,V>  allEntries;

		/**
		 * Constructor:   make a linkedlist (HashLinkedList) 'allEntries' of all the entries in the hash table
		 */
		public  HashIterator()
		{

			//  ADD YOUR CODE BELOW HERE
			allEntries = new HashLinkedList<K,V>();
			HashNode<K,V> tempNode, newNode = null;
		
			for (int i = 0; i < numBuckets; i++) {			
				if (buckets.get(i).getFirst() != null) {
					tempNode = buckets.get(i).getFirst();
					while (tempNode != null) {
						newNode = tempNode.clone();
						allEntries.add(newNode.getKey(), newNode.getValue());
						if (tempNode.getNext() != null) tempNode = tempNode.next;
						else break;
					}
					
				}
			}

			//  ADD YOUR CODE ABOVE HERE

		}

		//  Override
		@Override
		public boolean hasNext()
		{
			return !allEntries.isEmpty();
		}

		//  Override
		@Override
		public HashNode<K,V> next()
		{
			return allEntries.removeFirst();
		}

		@Override
		public void remove() {
			// not implemented,  but must be declared because it is in the Iterator interface

		}		
	}

}
