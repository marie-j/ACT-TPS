package hauteur_limitee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import premiere_approche_n3.Cmp;
import premiere_approche_n3.Point;
import premiere_approche_n3.Reader;

public class Main {
	
	protected static void printList (List<Point> tab) {
		System.out.println("taille : " + (tab.size() - 2));
		
		for (int i = 0 ; i < tab.size() ; i++) {
			Point p = tab.get(i);
			System.out.println("x : " + p.getKey() + " y : " + p.getValue());
		}
	}
	
	public static int max_3 (int a , int b , int c) {
		
		return Math.max(Math.max(a,b), c);
	}
	
	public static int rec (int width, int height, int n , List<Point> tab,List<Point> tmp) {
		
		if (n == 0) {
			return width * height;
		}
		else {
			
			int hauteurMin = tmp.get(0).getValue();
			int abs = tmp.get(0).getKey();
			int pivot = recherche_dichotomique(abs,tab);
			
			if (pivot == - 1) {
				return rec(width,height,n,tab, tmp.subList(1, tmp.size()));
			}
			else {
				int length = tab.size();
				int middle = (tab.get(length -1).getKey() - tab.get(0).getKey()) * hauteurMin;
				int left = rec(tab.get(pivot).getKey() - tab.get(0).getKey(),height,pivot -1,tab.subList(0, pivot +1),tmp.subList(1, tmp.size()));
				int right = rec(tab.get(length -1).getKey() - tab.get(pivot).getKey(),height,n - pivot,tab.subList(pivot, length),tmp.subList(1, tmp.size()));
				
				return max_3(left,middle,right);
			}
		}
	}

	private static int recherche_dichotomique(int abs,List<Point> tab) {
		int g = 0;
		int d = tab.size() - 1;
		
		while (g <=d) {
			int m = (g +d)/2;
			if (tab.get(m).getKey() > abs) {
				d = m - 1;
			}
			else if (tab.get(m).getKey() < abs) {
				g = m + 1;
			}
			else {
				return m;
			}
		}
		return -1;
		
	}

	public static void main(String[] args) throws IOException {
		
		String path = args[0];
		int newHeight = Integer.parseInt(args[1]);
		Reader fr = new Reader();
		
		fr.read(path);
		
		List<Point> tmp = new ArrayList<Point>();
		tmp.addAll(fr.tab);
		
		tmp.sort(new Cmp_y());
		
		//on trie le tableau par abscisses des points croissantes
		fr.tab.sort(new Cmp());
	
		
		int max = rec(fr.width,newHeight,fr.number,fr.tab,tmp.subList(1, tmp.size() - 1));
		
		System.out.println(max);
	}

}
