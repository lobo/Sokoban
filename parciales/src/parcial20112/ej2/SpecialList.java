package parcial20112.ej2;

import java.util.List;

public interface SpecialList<T> extends List<T> {
	public <S> Iterable<S> iterable(Function <T,S> f);
}


