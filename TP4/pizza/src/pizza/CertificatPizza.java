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
				Iterator<Case> itPart = part.iterator();
				int cpt =0; 
				
				while (itPart.hasNext()) {
					Case c = itPart.next(); 
					if (this.pb.getPizza()[c.x][c.y]) {
						cpt++; 
					}
					
				}
			}
		}
		
		return true; 
	}

}
