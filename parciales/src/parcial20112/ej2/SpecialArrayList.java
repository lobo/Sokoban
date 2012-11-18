package parcial20112.ej2;

import java.util.ArrayList;

public class SpecialArrayList<T> extends ArrayList<T> implements SpecialList<T> {
	private static final long serialVersionUID = 1L;

	public <S> Iterable<S> iterable(Function<T,S> f){
		return new SpecialIterable(this,f);
	}
	
}
