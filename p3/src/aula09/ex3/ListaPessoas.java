package aula09.ex3;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {
	private List<Pessoa> lista;
	
	public ListaPessoas() {
		this.lista = new ArrayList<Pessoa>();
	}
	public void addPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		lista.add(pessoa);
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ListIterador();
	}
	public BFIterator bfiterator() {
		// TODO Auto-generated method stub
		return new ListBFIterator();
	}
	
	private class ListIterador implements Iterator{
		private int in;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < lista.size());
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				Object n = lista.get(in);
				in++;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+lista.size()+" elements");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Nao suportada");
			
		}
		
	}
	private class ListBFIterator implements BFIterator{
		private int in;

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (in >= lista.size());
		}

		@Override
		public Object previous() {
			
			if (hasPrevious()) {
				Object n = lista.get(in);
				in--;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+lista.size()+" elements");
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < lista.size());
		}

		@Override
		public Object next() {
			if (hasNext()) {
				Object n = lista.get(in);
				in++;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+lista.size()+" elements");
		}
		
	}

}
