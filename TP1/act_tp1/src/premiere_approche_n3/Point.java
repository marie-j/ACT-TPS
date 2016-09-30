package premiere_approche_n3;

public class Point implements Comparable<Point>{

		protected int x;
		protected int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getKey() {
			return x;
		}
		
		public int getValue() {
			return y;
		}

		public int compareTo(Point o) {
			
			if (this.y < o.getValue()) {
				return -1;
			}
			else if (this.y > o.getValue()) {
				return 1;
			}
			else {
				return 0;
			}
		}
}
