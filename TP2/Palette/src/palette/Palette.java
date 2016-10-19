package palette;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Palette {
	
	protected int[] range = new int[256];
	protected int[][] tab = new int[256][256];
	
	public int best_grey(int first, int last) {
		
		int total = 0;
		int sum = 0;
		
		for (int i = first; i <= last ; i ++) {
			total += this.range[i];
			sum += this.range[i]*i;
		}
		
		if (first == last) {
			return first;
		}
		else {
			return Math.floorDiv(sum, total);	
		}	
	}
	
	public int min_distance(int first, int last) {
		int best = best_grey(first,last);
		int dist = 0;
		for (int i = first ; i <= last ; i++) {
			dist += (i - best)* (i -best) * this.range[i];
		}
		return dist;
	}
	
	public int rec(int first, int last, int k) {
		if (k == 1) {
			if (this.tab[first][last] == Integer.MAX_VALUE) {
				this.tab[first][last] = min_distance(first,last);
			}
			return this.tab[first][last];
		}
		else {
			for (int i = first + 1 ; i < last - 1 ; i++) {
				if (this.range[i] != 0) {
					if (this.tab[first][i] == Integer.MAX_VALUE) {
						this.tab[first][i] = min_distance(first,i);
					}
					
					this.tab[first][last] = Math.min(this.tab[first][last], tab[first][i] + rec(i +1,last,k-1));
				}
			}
			return this.tab[first][last];
		}
	}
	
	public int[] split_image(int k) {
		for (int i = 0 ; i < 256 ; i++) {
			for (int j = 0 ; j <256; j++) {
				this.tab[i][j] = Integer.MAX_VALUE;
			}
		}
		rec(0,255,k);

		int min = this.tab[0][255];
		int cpt = k; 
		int end = 255;
		int start = 255;
		boolean restart = false;
		int tmp = start;
		
		int[] rem = new int[k -1];
		
		while (min != 0 && cpt != 1) {
			
			for (int i = start ; i >= 0 ;i--) {
				
				tmp = i;
				
				if (this.tab[i][end] != Integer.MAX_VALUE && this.tab[i][end] <= min) {
					
					
					min -= this.tab[i][end];
					
					if(cpt != 1) {
						rem[cpt - 2] = i;
					}
					
					if (i == 0) {
						restart = true;
					}
					else {
						start = i -1;
						end = i -1;
						cpt--;
					}
					
					break;
				}
			}
			
			if (restart && min != 0) {
				cpt++;
				end = rem[cpt - 2];
				min = this.tab[0][255];
				start = tmp; 
				restart = false;
			}
		}
		
		return rem;
	}

	public static void main(String[] args) throws IOException {
		String path = args[0];
		int k = Integer.parseInt(args[1]);
		List<Integer> img = new ArrayList<Integer>();
		
		Palette p = new Palette();
		
		InputStream ips = null;
		
		try {
			ips = new FileInputStream(path);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		int grey = ips.read();
		while (grey != -1) {
			if (grey != '\n') {
				img.add(grey);
			}
			grey = ips.read();
		}
		
		for (int i = 0 ; i < img.size() ; i++) {
				p.range[img.get(i)]++;
		}
		
		int[] tab = p.split_image(k);
		int[] new_grey = new int[k];
		
		int start = 0;
		for (int i = 0 ; i < k -1 ; i++) {
			new_grey[i] = p.best_grey(start, tab[i] - 1);
			start = tab[i];
		}
		
		new_grey[k - 1] = p.best_grey(start,255);
		int [] new_img = new int[img.size()];
		
		for (int i = 0 ; i <img.size();i++) {
				int pixel = img.get(i);
				if (pixel > tab[k - 2]) {
					new_img[i] = new_grey[k - 1];
				}
				else {
					for (int l = 0 ; l < k -1 ; l++ ) {
						if (pixel < tab[l]) {
							new_img[i] = new_grey[l];
							break;
					}
				}
			}
		}
		
		int lg = new_img.length;
		for (int i = 0 ; i < lg ; i++) {
			System.out.printf("%d",new_img[i]);
			System.out.println();
			
		}
	}

}
