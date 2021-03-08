package com.vikko.demo.suanfa.year2021.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/3/2 12:14
 * @Description:
 */
class LRUCache<K,V> {

	// 双向链表节点定义
	class Node {
		K key;
		V val;
		Node prev;
		Node next;
	}

	private int capacity;
	//保存链表的头节点和尾节点
	private Node first;
	private Node last;

	private Map<K, Node> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}

	public V get(K key) {
		Node node = map.get(key);
		//为空返回-1
		if (node == null) {
			return null;
		}
		moveToHead(node);
		return node.val;
	}

	private void moveToHead(Node node) {
		if (node == first) {
			return;
		} else if (node == last) {
			last.prev.next = null;
			last = last.prev;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		node.prev = first.prev;
		node.next = first;
		first.prev = node;
		first = node;
	}

	public void put(K key, V value) {
		Node node = map.get(key);

		if (node == null) {
			node = new Node();
			node.key = key;
			node.val = value;

			if(map.size() == capacity) {
				removeLast();
			}

			addToHead(node);
			map.put(key, node);
		} else {
			node.val = value;
			moveToHead(node);
		}
	}

	private void addToHead(Node node) {
		if (map.isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first.prev = node;
			first = node;
		}
	}

	private void removeLast() {
		map.remove(last.key);
		Node prevNode = last.prev;
		if (prevNode != null) {
			prevNode.next = null;
			last = prevNode;
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache<Integer,Integer>(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.get(1);
		cache.put(4, 3);
		System.out.println(cache);
	}
}
