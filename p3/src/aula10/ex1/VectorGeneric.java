package aula10.ex1;

import java.util.Iterator;

public class VectorGeneric<T> implements Iterable {
	private T lista[];
	private int n;
	private int dim;
	
	public VectorGeneric() {
		lista =  (T[]) new Object[50];
		n = 0;
	}
	
	public boolean addElem(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			return false;
		}
		if (n >= dim) {
			dim += 50;
			T newar[] =  (T[]) new Object[dim];
			System.arraycopy(lista, 0, newar, 0, n);
			lista = newar;
		}
		lista[n++] = elem;
		return true;
	}
	
	public boolean removeElem(T elem) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			if (lista[i] == elem) {
				n--;
				for (int j = i; j < n; j++) {
					lista[j] = lista[j+1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalpessoas() {
		return n;
	}
	
	public Object getElem(int i) {
		return lista[i];
	}

	public Iterator iterator() {
		return new VectorIterador();
	}
	
	private class VectorIterador implements Iterator<T>{
		private int in;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < n);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				Object n = lista[in];
				in++;
				return (T)n;
			}
			throw new IndexOutOfBoundsException("only "+n+" elements");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Nao suportada");
			
		}
		
	}
}
