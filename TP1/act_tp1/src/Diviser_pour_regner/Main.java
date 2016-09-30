package Diviser_pour_regner;

import java.io.IOException;
import java.util.List;

import premiere_approche_n3.Cmp;
import premiere_approche_n3.Point;
import premiere_approche_n3.Reader;

public class Main {
	
	
	public static int max_3 (int a , int b , int c) {
		
		return Math.max(Math.max(a,b), c);
	}
	
	public static int rec (int width, int height, int n , List<Point> tab) {
		
		if (n == 0) {
			return width * height;
		}
		else {
			
			int pivot = 1; 
			int minHeight = tab.get(pivot).getValue();
			int length = tab.size();
			for (int i = 2 ; i < length -1 ; i++) {
				if (tab.get(i).getValue() < minHeight && tab.get(i).getValue() != 0) {
					minHeight = tab.get(i).getValue();
					pivot = i;
				}
				if (tab.get(i).getValue() == minHeight && Math.abs(length/2 - i) < Math.abs(length/2 - pivot)) {
					pivot = i; 
				}
			}
			
			int middle = (tab.get(length -1).getKey() - tab.get(0).getKey()) * tab.get(pivot).getValue();
			int left = rec (tab.get(pivot).getKey() - tab.get(0).getKey(),height,pivot -1,tab.subList(0, pivot +1));
			int right = rec(tab.get(length - 1).getKey()- tab.get(pivot).getKey(),height, n - pivot, tab.subList(pivot, length));
			
			return max_3(left,middle,right);
		}
	}

	public static void main(String[] args) throws IOException {
		
		String path = args[0];
		Reader fr = new Reader();
		
		fr.read(path);
		
		//on trie le tableau par abscisses des points croissantes
		fr.tab.sort(new Cmp());
		
		int max = rec(fr.width,fr.height,fr.number,fr.tab);
		
		System.out.println(max);
	}

}
