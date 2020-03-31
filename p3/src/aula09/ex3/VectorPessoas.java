package aula09.ex3;



public class VectorPessoas {
	private Pessoa lista[];
	private int n_pes;
	private int dim;
	
	public VectorPessoas() {
		lista = new Pessoa[50];
		n_pes = 0;
	}
	
	public boolean addPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		if (pessoa == null) {
			return false;
		}
		if (n_pes >= dim) {
			dim += 50;
			Pessoa newar[] = new Pessoa[dim];
			System.arraycopy(lista, 0, newar, 0, n_pes);
			lista = newar;
		}
		lista[n_pes++] = pessoa;
		return true;
	}
	
	public boolean removePessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n_pes; i++) {
			if (lista[i] == pessoa) {
				n_pes--;
				for (int j = i; j < n_pes; j++) {
					lista[j] = lista[j+1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalpessoas() {
		return n_pes;
	}
	
	public Pessoa getPessoa(int i) {
		return lista[i];
	}

	public Iterator iterator() {
		return new VectorIterador();
	}
	public BFIterator bfiterator() {
		// TODO Auto-generated method stub
		return new VectorBFIterator();
	}
	
	private class VectorIterador implements Iterator{
		private int in;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < n_pes);
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				Object n = lista[in];
				in++;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+n_pes+" elements");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Nao suportada");
			
		}
		
	}
	private class VectorBFIterator implements BFIterator{
		private int in;

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (in >= n_pes);
		}

		@Override
		public Object previous() {
			
			if (hasPrevious()) {
				Object n = lista[in];
				in--;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+n_pes+" elements");
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (in < n_pes);
		}

		@Override
		public Object next() {
			if (hasNext()) {
				Object n = lista[in];
				in++;
				return n;
			}
			throw new IndexOutOfBoundsException("only "+n_pes+" elements");
		}
		
	}
	

}
