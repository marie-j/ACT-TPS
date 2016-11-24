package binpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	
private static BufferedReader donnee;

public static void main(String[] args) throws Exception {
    if (args.length < 3){
	    System.out.println("Usage: java -jar binpack.jar <file> <mode> <nbsacs>");
		System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}
	else {
		donnee = new BufferedReader (new FileReader(args[0]));
        int cap=Integer.parseInt(donnee.readLine());
        int nbObjets=Integer.parseInt(donnee.readLine());
        int poids[]=new int[nbObjets];
        for (int i=0;i< nbObjets;i++) poids[i]=Integer.parseInt(donnee.readLine());
        int nbSacs=Integer.parseInt(args[2]);
        PblBinPack pb=new PblBinPack(nbObjets,poids,nbSacs,cap);
        if (args[1].equals("-exh")) {
        	boolean tmp = pb.aUneSolution();
        	System.out.println(tmp);
        	if (tmp) {
        		pb.getCertificat().affiche();
        	}
        }
        	
        else if (args[1].equals("-nd")) {
        	boolean tmp = pb.aUneSolutionNonDeterministe();
        	System.out.println(tmp);
        	if (tmp) {
        		pb.getCertificat().affiche();
        	}
        }
        else if (args[1].equals("-ver")) {
            BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
            int aff[]=new int[nbObjets];
            for (int i=0;i < nbObjets; i++) {
                System.out.print("donnez un no de sac de 0 a "); System.out.println(nbSacs - 1);
                System.out.print("pour l'objet "); System.out.println(i);
                aff[i]=Integer.parseInt(entree.readLine());
                if (aff[i]<0 || aff[i]>=nbSacs) throw new Exception("valeur non autorisee");}
            Certificat cert =new CertificatBinPack(pb,aff); //constructeur qui affecte aux sacs les valeurs de aff;
            System.out.println(cert.estCorrect());
        }
        else {
            System.out.println("Usage: java -jar binpack.jar <file>  <mode> <nbsacs>");
            System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}

 	}
}
}
