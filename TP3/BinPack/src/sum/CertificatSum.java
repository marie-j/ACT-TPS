package sum;

import binpack.Certificat;
import partition.*;

public class CertificatSum implements Certificat {
	
	protected CertificatPartition c; 
	private int[] repartition; 
	protected PblSum pb; 
	
	public CertificatSum(PblSum pb) {
		this.pb = pb;
		this.c  = new CertificatPartition(pb.getPartRed());
	}
	
	public CertificatSum(PblSum pb, int[] aff) {
		this.pb = pb;
		this.repartition = aff;
		int[] tmp = new int[aff.length +1];
		int i =0;
		for ( ; i < aff.length ; i++) {
			tmp[i] = this.repartition[i];
		}
		tmp[i + 1] = this.pb.getAjout();
		this.c  = new CertificatPartition(pb.getPartRed(),tmp);
	}

	@Override
	public boolean estCorrect() {
		return c.estCorrect();
	}

	@Override
	public void suivant() {
		c.suivant();
		this.getSolution();

	}

	@Override
	public boolean estDernier() {
		return c.estDernier();
	}

	@Override
	public void alea() {
		c.alea();
		this.getSolution();

	}

	@Override
	public void affiche() {
		int s1 = 0;
		int s2 = 0;
		for (int i = 0 ; i < this.repartition.length ; i++) {
			if (this.repartition[i] ==0) {
				s1++;
			}
			else {
				s2++;
			}
		}
		int sac;
		if (s1 == this.pb.getCible()) {
			sac = 0;
		}
		else {
			sac = 1;
		}
		String eq = "";
		for (int i = 0 ; i < this.repartition.length; i++) {
			if (this.repartition[i] == sac) {
				eq += this.pb.getPartRed().getBinPackRed().getPoidsForObject(i) + " + ";
			}
		}
		System.out.println(this.pb.getCible() + " = " + eq.substring(0, eq.length() -3));

	}
	
	public void getSolution() {
		boolean found = false; 
		int[] aff = this.c.getRepartition();
		int ajout = this.pb.getAjout();
		int cpt = 0;
		for (int i = 0 ; i < aff.length ; i++) {
			if (!found || aff[i] == ajout) {
				found = true;
			}
			else {
				this.repartition[cpt] = aff[i];
				cpt++;
			}
		}
	}
	
	public int[] getRepartition() {
		return this.repartition;
	}

}
