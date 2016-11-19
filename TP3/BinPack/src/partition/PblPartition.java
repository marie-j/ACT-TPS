package partition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import binpack.Certificat;
import binpack.CertificatBinPack;
import binpack.PblBinPack;
import binpack.PblDec;

public class PblPartition extends PblDec {

	private PblBinPack red;
	private static BufferedReader s;
	
	public PblPartition(int n, int p[]) {
		int c = 0;
		for (int i = 0 ; i < p.length ; i++) {
			c += p[i];
		}
		c /= 2;
		this.red = new PblBinPack(n,p,2,c);
	}
	
	
	public PblBinPack getBinPackRed() {
		return this.red;
	}

	@Override
	public boolean aUneSolution() {
		return this.red.aUneSolution();
	}
	
	public boolean aUneSolutionNonDeterministe() {
		return this.red.aUneSolutionNonDeterministe();
	}
	
	public static void main(String[] args) throws Exception {
	    if (args.length < 2){
		    System.out.println("Usage: java -jar partition.jar <file> <mode>");
			System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}
		else {
			s = new BufferedReader (new FileReader(args[0]));
	        int nbObjets=Integer.parseInt(s.readLine());
	        int poids[]=new int[nbObjets];
	        for (int i=0;i< nbObjets;i++) poids[i]=Integer.parseInt(s.readLine());
	        PblPartition pb=new PblPartition(nbObjets,poids);
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
	            Certificat cert =new CertificatBinPack(pb.getBinPackRed(),aff);
	            System.out.println(cert.estCorrect());
	        }
	        else {
	            System.out.println("Usage: java  testBinPack <file>  <mode>ss");
	            System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}

	 	}
	}
	
}
