import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class Cmp implements Comparator<Point>{

	public int compare(Point o1, Point o2) {
		
		int x1 = o1.getKey();
		int x2 = o2.getKey();
		
		if (x1 > x2) {
			return 1;
		}
		else if (x1 == x2) {
			return 0;
		}
		else {
			return -1;
		}
	}

	public Comparator<Point> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Point> thenComparing(Comparator<? super Point> other) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Point> thenComparing(
			Function<? super Point, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Point> thenComparing(
			Function<? super Point, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Point> thenComparingInt(
			ToIntFunction<? super Point> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Point> thenComparingLong(
			ToLongFunction<? super Point> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Point> thenComparingDouble(
			ToDoubleFunction<? super Point> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(
			ToIntFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(
			ToLongFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
