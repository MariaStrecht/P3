package aula10.ex1;

import java.util.ArrayList;

import java.util.*;

public class ListaGeneric<T> implements Iterable<T> {
	private List<T> lista = new ArrayList<T>();
	
	public boolean addElem(T elem) {
		// TODO Auto-generated method stub
		return lista.add(elem);
	}
	public boolean removeElem(T elem) {
		return lista.remove(elem);
	}
	public int totalElem() {
		return lista.size();
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ListIterador();
	}
	
	private class ListIterador implements Iterator<T>{
		private int in;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < lista.size());
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				Object n = lista.get(in);
				in++;
				return (T)n;
			}
			throw new IndexOutOfBoundsException("only "+lista.size()+" elements");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Nao suportada");
			
		}
		
	}
}
