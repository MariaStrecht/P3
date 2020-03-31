package aula10.ex2;

import java.util.Iterator;
import java.util.Stack;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	// o elemento do tipo T deve ser comparável para efectuar pesquisas
	// mas como pode herdar a implementação de compareTo() é mais correcto
	// usar <? super T>
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
	}
	private BSTNode<T> root;
	private int numNodes;
	
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	public void insert(T value) {
		root = insert(value, root);
	}
	
	public BSTNode<T> insert(T value, BSTNode<T> rot) {
		if (root == null) {
			return new BSTNode<T>(value);
		}
		if (rot.element.compareTo(rot.element) > 0) {
			rot.left = insert(value,rot.left);
		}else if (rot.element.compareTo(rot.element) < 0) {
			rot.right = insert(value,rot.right);
		}else {
			return rot;
		}
		return rot;
	}
	
	public void remove(T value) {
		root = remove(value, root);
	}
	
	public BSTNode<T> remove(T value, BSTNode<T> rot){
		if (rot == null) {
			return null;
		}
		if (rot.element.equals(value)) {
			// found node delete it
			return delete(rot);
			
		}
		if (rot.element.compareTo(value) > 0) {
			rot.left = remove(value, rot.left);
		}
		rot.right = remove(value, rot.right);
		
		return rot;
	}
	
	public BSTNode<T> delete(BSTNode<T> rot){
		if (rot.left == null & rot.right == null) {
			return null;
		}
		if (rot.left == null) {
			return rot.right;
		}
		if (rot.right == null) {
			return rot.left;
		}		
		
		T tmp = findsmallest(rot.right);
		rot.element = tmp;
		rot.right = remove(tmp, rot.right);
		return rot;
	}
	
	public void delete_v2(T element) {
		root = remove(element, root);
	}
	
	private T findsmallest(BSTNode<T> rot) {
		if (rot.left == null) {
			return rot.element;
		}
		return findsmallest(rot.left);
	}
	
	public boolean contains(T value) {
		return valueOf(find(value, root)) != null;
	}
	
	private Object valueOf(boolean find) {
		return find;
	}
	public boolean find(T value, BSTNode<T> rot){
		if (rot==null) {
			return false;
		}
		if (value == rot.element) {
			return true;
		}
		if (rot.element.compareTo(rot.element) > 0) {
			return find(value,rot.left);
		}
			
		return find(value,rot.right);
		
		
	}
	
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<E> implements Iterator<E>{
		Stack<BSTNode<E>> stack;
		
		public BSTIterator(BSTNode<E> node) {
			stack = new Stack<BSTNode<E>>();
			while (root != null) {
				stack.push(node);
				node = node.left;
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public E next() {
			BSTNode<E> top = stack.pop();
			E top_elm = top.element;
			if (top.right != null) {
				top = top.right;
				while (top == null) {
					stack.push(top);
					top = top.left;
				}
			}
			return top_elm;
		}
		
		
	}
}