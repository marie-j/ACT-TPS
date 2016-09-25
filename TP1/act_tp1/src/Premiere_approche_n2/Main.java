package Premiere_approche_n2;

import java.io.IOException;
import premiere_approche_n3.Reader;
import premiere_approche_n3.Cmp;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		// lecture du fichier en paramètre
		String path = args[0];
		Reader fr = new Reader();
		
		fr.read(path);
		
		int max = 0;
		
		
		
		//on trie le tableau par abscisses des points croissantes
		fr.tab.sort(new Cmp());
		
		if (fr.number == 0) {
			max = fr.width * fr.height;
		}
		else {
			
			// Algo en n2 trouvé 
			for (int i = 0 ; i <= fr.number ; i++ ) {
				
				int abs = fr.tab.get(i).getKey(); 
				int tmp = fr.tab.get(i+1).getValue();
				
				int minHeight = 0;
				
				for (int j = i + 1 ; j <= fr.number + 1  ; j++) {
					
					int width = fr.tab.get(j).getKey() - abs;
					int y = fr.tab.get(j).getValue();
					
					if (j == i +1) {
						minHeight = fr.height;
					}
					else {
						minHeight = tmp;
					}
					
					if (y < tmp && y != 0) {
						tmp = y;
					}	
					
					
					int res = minHeight * width;
					
					if (res > max) {
						max = res;
					}
				}
						
			}
		}
		System.out.println(max);
	}

}
