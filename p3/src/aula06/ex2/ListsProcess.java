package aula06.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListsProcess {

	public static <E> List<E> filter(List<E> lista, Predicate<E> filtro) {
		// TODO Auto-generated method stub
		List<E> nova = new ArrayList<>();
		for (E e : lista) {
			if (filtro.test(e)) {
				nova.add(e);
			}
		}
		return nova;
	}

}
