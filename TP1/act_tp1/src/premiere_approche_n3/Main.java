package premiere_approche_n3;

import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
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
			
			// Algo en n3 trouvé 
			for (int i = 0 ; i <= fr.number ; i++ ) {
				
				int abs = fr.tab.get(i).getKey(); 
				
				for (int j = i + 1 ; j <= fr.number +1 ; j++) {
					
					int width = fr.tab.get(j).getKey() - abs;
					int minHeight = fr.height;
					
					for (int k = i +1 ; k < j ; k++) {
						
						if (minHeight > fr.tab.get(k).getValue() && fr.tab.get(k).getValue() != 0 ) {
							minHeight = fr.tab.get(k).getValue();
						}
						
					}
					
					int tmp = minHeight * width;
					if (tmp > max) {
						max = tmp;
					}
				}
						
			}
		}
		
		System.out.println(max);
	}
	
}
