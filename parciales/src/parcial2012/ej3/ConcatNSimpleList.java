package parcial2012.ej3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcatNSimpleList<T> implements SimpleList<String> {
	List<SimpleList<T>> colec = new ArrayList<SimpleList<T>>();

	/* Implementa un iterador porque SimpleList extiende a Iterable */
	/* La idea es que este iterador interpreta a todas las listas como si fuera 
	 * una sola ordenada. 
	 */
	@Override
	public Iterator<String> iterator() {
		return new ConcatIterator();
	}
	
	/* Gracias a que devuelvo this, puedo ir concatenando una llamada despues
	 * de la otra
	 */
	public ConcatNSimpleList<T> add(SimpleList<T> l){
		colec.add(l);
		return this;
	}

	@Override
	public void append(String elem) {

	}
	
	private class ConcatIterator implements Iterator<T>{
		/* A la coleccion le pido su iterador, cada vez que le pido un next, me 
		 * va a devolver una lista
		 */
		private Iterator<SimpleList<T>> colIt = colec.iterator();
		/* Ademas, necesito un iterador para la lista actual */
		private Iterator<T> listIt = null;

		@Override
		public boolean hasNext() {
			while (listIt == null || !listIt.hasNext() ) {
				if (colIt.hasNext()) {
					listIt = colIt.next().iterator();
				}
				else {
					return false;
				}
			}
			return true;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
