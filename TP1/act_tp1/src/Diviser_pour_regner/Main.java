package Diviser_pour_regner;

import java.io.IOException;
import java.util.List;

import premiere_approche_n3.Cmp;
import premiere_approche_n3.Point;
import premiere_approche_n3.Reader;

public class Main {
	
	protected static List<Point> splice (int index, List<Point> tab) {
		List<Point> l1 = tab.subList(0, index);
		List<Point> l2 = tab.subList(index + 1, tab.size());
		l1.addAll(l2);
		return l1;
	}
	
	protected static int max_3 (int a , int b , int c) {
		
		return Math.max(Math.max(a,b), c);
	}
	
	protected static int rec (int width , int height , int n , List<Point> tab) {
		
		if (n == 0) {
			return width * height; 
		}
		
		else {	
			int tmp = n/2 + 1 ; 
			Point pivot = tab.get(tmp);
			int length = tab.size();
			
			int left ;
			int right;
			int middle;
			
			if (n % 2 == 0) {
				
				
				Point pivot_gauche = tab.get(tmp - 1);
				
				left = rec( pivot.getKey() - tab.get(0).getKey(),height,tmp - 1,tab.subList(0,tmp + 2));
				right = rec(tab.get(length - 1).getKey() - pivot_gauche.getKey(),height, tmp - 1, tab.subList(tmp - 1, length));
				middle = height * (pivot.getKey() - pivot_gauche.getKey());
			}
			else {
				
				left = rec( pivot.getKey() - tab.get(0).getKey(),height,tmp - 1,tab.subList(0, tmp + 1));
				right = rec (tab.get(length - 1).getKey() - pivot.getKey(),height, tmp - 1 ,tab.subList(tmp, length));
				
				if (pivot.getValue() < Math.max(tab.get(tmp -1).getValue(), tab.get(tmp + 1).getValue())) {
					middle = (tab.get(tmp + 1).getKey()- tab.get(tmp - 1).getKey()) * pivot.getValue();
				}
				
				else {
					middle = rec(width, pivot.getValue(),n - 1 , splice(tmp,tab));
				}
				
				
			}
			
			return max_3(right,left,middle);
			
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
