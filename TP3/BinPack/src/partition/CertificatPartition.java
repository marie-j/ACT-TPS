package partition;

import binpack.Certificat;
import binpack.CertificatBinPack;

public class CertificatPartition implements Certificat {
	
	protected CertificatBinPack c; 
	private int[] repartition; 
	protected PblPartition pb; 
	
	public CertificatPartition(PblPartition pb) {
		this.pb = pb;
		this.c  = new CertificatBinPack(pb.getBinPackRed());
	}
	
	public CertificatPartition(PblPartition pb, int[] aff) {
		this.pb = pb;
		this.c  = new CertificatBinPack(pb.getBinPackRed(),aff);
		this.repartition = aff;
	}

	@Override
	public boolean estCorrect() {
		return c.estCorrect();
	}

	@Override
	public void suivant() {
		c.suivant();
		getSolution();

	}

	@Override
	public boolean estDernier() {
		return c.estDernier();
	}

	@Override
	public void alea() {
		c.alea();
		getSolution();

	}

	@Override
	public void affiche() {
		String eq1 = "";
		String eq2 = "";
		for (int i = 0 ; i < this.repartition.length ; i++) {
	 		if (this.repartition[i] == 0) {
	 			eq1 +=  this.pb.getBinPackRed().getPoidsForObject(i) + " + ";
	 		}
	 		else {
	 			eq2 +=  this.pb.getBinPackRed().getPoidsForObject(i) + " + ";
	 		}
	 	}
		
		System.out.println(eq1.substring(0, eq1.length() - 3) + " = " + eq2.substring(0, eq2.length() - 3));

	}
	
	public void getSolution() {
		this.repartition = c.getRepartition();
	}
	
	public int[] getRepartition() {
		return this.repartition;
	}


}
