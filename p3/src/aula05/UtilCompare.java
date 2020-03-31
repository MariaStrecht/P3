package aula05;

public class UtilCompare {
	public static <T> Comparable<T> findMax(Comparable<T> []a){
		int maxIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null && a[i].compareTo((T) a[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return a[maxIndex];
	}
	public static <T> void sortArray(Comparable<T> []a){
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] != null && a[i].compareTo((T) a[j]) > 0) {
					Comparable<T> tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
	}
}
