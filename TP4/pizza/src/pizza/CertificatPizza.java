package pizza;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CertificatPizza {
	
	protected PblPizza pb; 
	protected List<List<Case>> decoupe; 
	
	public CertificatPizza(PblPizza pb) {
		this.pb = pb; 
		this.decoupe = new ArrayList<List<Case>>();
	}
	
	public CertificatPizza(PblPizza pb, List<List<Case>> decoupe) {
		this.pb = pb; 
		this.decoupe = decoupe; 
	}
	
	public boolean estCorrect() {
		
		Iterator<List<Case>> it = this.decoupe.iterator();
		while (it.hasNext()) {
			List<Case> part = it.next();
			
			if (part.size() > this.pb.getMax() || part.size() % 2 == 1) {
				return false; 
			}
			else {
				if (part.size() != 0) {
					Iterator<Case> itPart = part.iterator();
					Case c = itPart.next(); 
					int lMin = c.x;
					int lMax = c.x;
					int hMin = c.y; 
					int hMax = c.y;
					int cpt = 0; 
					if (this.pb.getPizza()[c.x][c.y]) {
						cpt++; 
					}
					while (itPart.hasNext()) {
						c = itPart.next();
						if (c.x < hMin) {
							hMin = c.x;
						}
						if (c.x > hMax) {
							hMax = c.x;
						}
						if (c.y < hMin) {
							hMin = c.y;
						}
						if (c.y > hMax) {
							hMax = c.y;
						}
						
						if (this.pb.getPizza()[c.x][c.y]) {
							cpt++;
						}
					}
					
					return (hMax - hMin) * (lMax - lMin) == part.size() && cpt >= this.pb.getHam();
					
				}				
			}
		}
		
		return true; 
	}

}
