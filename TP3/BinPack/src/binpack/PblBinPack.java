package binpack;

public class PblBinPack extends PblDec
{ 
    private int nbObjets; 
    private int poids[];
    private int cap;
    private int nbSacs;
     //  //
    public PblBinPack(int n, int p[], int nbs, int c){
    nbObjets=n;
    poids=p;
    cap=c;
    nbSacs=nbs;
    }
    
     //retourne Vrai SSi le pb a une solution
 // essaie tous les certificats un à un jusqu'à en trouver un correct -si il existe	....
    public boolean aUneSolution() {
    	
    //on place tous les objets dans le premier sac 
    int[] aff = new int[this.nbObjets];
    for (int i = 0 ; i < this.nbObjets ; i++) {
    	aff[i] = 0; 
    }
    
    CertificatBinPack c = new CertificatBinPack(this,aff);
    
    //tant qu'on a pas parcouru tous les certificats 
    while (!c.estDernier()) {
    	   	
    	//si le certificat vérifie l'algo alors il ya une solution au moins 
    	if (c.estCorrect()) {
    		return true;
    	}
    	//sinon on passe au certificat suivant 
    	else {
    		c.suivant();
    	}
    }
    
    return false;
    }
    
    //Algo non déterministe
  //génère alétaoirement un certificat et vérifie si il est correct
    //si il y aune solution, au moins une exécution doit retourner Vrai
    // sinon, toutes les exécutions doivent retourner Faux
    public boolean aUneSolutionNonDeterministe() {
    	
    	CertificatBinPack c = new CertificatBinPack(this);
    	c.alea();
    	return c.estCorrect();
    }

   // différents accesseurs, fonctions affichage ...}
    
    public int[] getPoids() {
    	return this.poids;
    }
    
    public int getNbObjets() {
    	return this.nbObjets;
    }
    
    public int getNbSacs() {
    	return this.nbSacs;
    }
    
    public int getCapacity() {
    	return this.cap;
    }
   
    public int getPoidsForObject(int index) {
    	return this.poids[index];
    }
    
}
