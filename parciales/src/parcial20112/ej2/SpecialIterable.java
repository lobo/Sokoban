package parcial20112.ej2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Los parametros que recibe son independientes de los de las otras 
 * clases.
 */
public class SpecialIterable<T,S> implements Iterable<S> {
	SpecialArrayList<T> list;
	Function<T,S> f;
	
	public SpecialIterable (SpecialArrayList<T> list, Function<T,S> f){
		this.list = list;
		this.f = f;
	}
	
	/* Como implementa Iterable, es necesario implementar un Iterator.
	 * Necesito hacer un iterador que en el momento haga la iteracion, para
	 * ver todo el tiempo a los objetos originales.
	 * 
	 * Este lo voy a hacer como clase inner.
	 */
	
	public Iterator<S> iterator(){
		return new SpecialIterator();
	}
	
	private class SpecialIterator implements Iterator<S>{
		/* Primero uso un iterador de la lista original, los metodos son 
		 * mas simples */
		private Iterator<T> it = list.iterator();
		
		@Override
		public boolean hasNext(){
			return it.hasNext();
		}

		
		public S next() {
			if (hasNext()) {
				return f.apply(it.next());
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			it.remove();
		}
		
	}
}
