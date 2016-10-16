package palette;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
		
		return Math.floorDiv(sum, total);
		
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
				if (i != j) {
					this.tab[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		rec(0,255,k);
		
		int d = this.tab[0][255];
		int end = 255;
		int[] rem = new int[k - 1];
		
		while (d != 0) {
			for(int i = k-2 ; i >= 0 ; i-- ) {
				for (int j = end ; j >=0 ; j-- ) {
					if (this.tab[j][end] != Integer.MAX_VALUE) {
						d -= this.tab[j][end];
						end = j -1;
						rem[i] = j;
						break;
					}
				}
			}
			
			if ( d < 0) {
				d = this.tab[0][255];
			}
		}
		
		return rem;
	}

	public static void main(String[] args) throws IOException {
		String path = args[0];
		int k = Integer.parseInt(args[1]);
		List<List<Integer>> img = new ArrayList<List<Integer>>();
		
		Palette p = new Palette();
		
		InputStream ips = null;
		
		try {
			ips = new FileInputStream(path);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		int grey = ips.read();
		List<Integer> tmp = new ArrayList<Integer>();
		while (grey != -1) {
			if (grey == '\n') {
				img.add(tmp);
				tmp.removeAll(tmp);
			}
			else {
				tmp.add(grey);
			}
			grey = ips.read();
		}
		
		for (int i = 0 ; i < img.size() ; i++) {
			for (int j = 0 ; j <img.get(i).size() ; j++) {
				p.range[img.get(i).get(j)]++;
			}
		}
		
		int[] tab = p.split_image(k);
		int[] new_grey = new int[k];
		
		int start = 0;
		for (int i = 0 ; i < k -1 ; i++) {
			new_grey[i] = p.best_grey(start, tab[i] - 1);
			start = tab[i];
		}
		
		new_grey[k] = p.best_grey(start,255);
		int [][] new_img = new int[img.size()][img.get(0).size()];
		
		for (int i = 0 ; i <img.size();i++) {
			for (int j = 0 ; j < img.get(i).size() ; j++) {
				int pixel = img.get(i).get(j);
				if (pixel > tab[k - 2]) {
					new_img[i][j] = new_grey[k - 1];
				}
				else {
					for (int l = 0 ; l < k -1 ; l++ ) {
						if (pixel < tab[l]) {
							new_img[i][j] = new_grey[l];
							break;
						}
					}
				}
			}
		}
		
		byte[] data = new_img.toString().getBytes();
		FileOutputStream out = new FileOutputStream("new_img");
		out.write(data);
		out.close();
	}

}
