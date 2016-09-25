package premiere_approche_n3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	public int width;
	public int height; 
	public int number;
	public List<Point> tab = new ArrayList<Point>();
	
	public void read(String path) throws IOException {
		
		
		InputStream ips; 
		InputStreamReader reader;
		BufferedReader br = null;
		
		
		
		try {
			ips = new FileInputStream(path);
			reader = new InputStreamReader(ips);
			br = new BufferedReader(reader);
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		// récupération de l et h 
		String line = br.readLine();
		this.width = Integer.parseInt(line.split(" ")[0]);
		this.height = Integer.parseInt(line.split(" ")[1]);
		
		//récupération de n 
		line = br.readLine();
		this.number = Integer.parseInt(line);
		line = br.readLine();
		
		//création du tableau de points
		this.tab.add(new Point(0,0)); 
		
		//on récupère tous les points 
		while (line != null) {
			
			String[] t = line.split(" ");
			int x = Integer.parseInt(t[0]);
			int y = Integer.parseInt(t[1]);
			
			this.tab.add(new Point(x,y));
			
			line = br.readLine();
		}
		
		br.close();
		
		//on ajoute le point (l,0)
		this.tab.add(new Point(this.width,0));
	}
}
