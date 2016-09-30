package hauteur_limitee;
import java.util.Comparator;

import premiere_approche_n3.Point;

public class Cmp_y implements Comparator<Point>{

	public int compare(Point o1, Point o2) {
		
		return (o1.compareTo(o2));
	}

}
