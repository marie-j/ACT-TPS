package sum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import binpack.Certificat;
import binpack.CertificatBinPack;
import binpack.PblDec;
import partition.PblPartition;

public class PblSum extends PblDec {
	
	public PblPartition pb; 
	
	public PblSum(int n, int x[], int c) {
		int[] l = new int[x.length + 1];
		int sum = 0;
		int i = 0;
		for (; i < x.length; i++) {
			l[i] = x[i];
			sum += x[i];
		}
		l[i] = sum - (2 * c); 
		this.pb = new PblPartition(n + 1,l);
	}

	@Override
	public boolean aUneSolution() {
		return this.pb.aUneSolution();
	}
	
	public boolean aUneSolutionNonDeterministe() {
		return this.pb.aUneSolutionNonDeterministe();
	}
	
	public PblPartition getPartRed() {
		return this.pb;
	}
	
	public static void main(String[] args) throws Exception {
	    if (args.length < 2){
		    System.out.println("Usage: java -jar sum.jar <file> <mode>");
			System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}
		else {
			BufferedReader s = new BufferedReader (new FileReader(args[0]));
	        int nbObjets=Integer.parseInt(s.readLine());
	        int poids[]=new int[nbObjets];
	        for (int i=0;i< nbObjets;i++) poids[i]=Integer.parseInt(s.readLine());
	        int c = Integer.parseInt(s.readLine());
	        PblSum pb=new PblSum(nbObjets,poids,c);
	        if (args[1].equals("-exh")) System.out.println(pb.aUneSolution());
	        else if (args[1].equals("-nd")) System.out.println(pb.aUneSolutionNonDeterministe());
	        else if (args[1].equals("-ver")) {
	            BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
	            int aff[]=new int[nbObjets];
	            for (int i=0;i < nbObjets; i++) {
	                System.out.print("préciser si l'entier est chosi (1) ou non (0) \n");
	                System.out.print("pour l'entier "); System.out.println(poids[i]);
	                aff[i]=Integer.parseInt(entree.readLine());
	                if (aff[i] != 0 && aff[i] != 1) throw new Exception("valeur non autorisee");}
	            Certificat cert =new CertificatBinPack(pb.getPartRed().getBinPackRed(),aff);
	            System.out.println(cert.estCorrect());
	        }
	        else {
	            System.out.println("Usage: java  testBinPack <file>  <mode>ss");
	            System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}

	 	}
	}

}
