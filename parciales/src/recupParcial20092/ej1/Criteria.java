package recupParcial20092.ej1;

/** Modela un criterio a aplicar a un objeto de tipo T */
public interface Criteria<T> {
	boolean satisfies(T obj);
}
