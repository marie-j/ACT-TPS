package binpack;

public class CertificatBinPack implements Certificat
{
	private PblBinPack pb;
	private int[] repartition; 

 public CertificatBinPack(PblBinPack p) {
	 this.pb = p; 
	 this.repartition = new int[p.getNbObjets()];
 }
    
 public CertificatBinPack(PblBinPack p, int[] aff) {
     this.pb = p; 
     this.repartition = aff;
    } 
    
    
 public boolean estCorrect(){
	 
	 //tableau qui stockera le poids de cahque sac
	 int[] tab = new int[this.pb.getNbSacs()];
	 
	 //on parcourt le certificat
	 for (int i = 0 ; i < this.repartition.length ; i++) {
		 //si l'objet n'est pas dans un sac le certificat n'est pas valide
		 if (this.repartition[i] == 0) {
			 return false;
		 }
		 //sinon on ajoute le poids dans le sac
		 else {
			 tab[this.repartition[i]] += this.pb.getPoidsForObject(i);
		 }
	 }
	 
	 //on parcourt tous les sacs
	 for (int i = 0 ; i < tab.length ; i++) {
		 //on vérifie que la capacité n'est pas depassée 
		 if (tab[i]> this.pb.getCapacity()) {
			 return false; 
		 }
	 }
  	
	 return true; 
	 
  }

 public void suivant() {
	 
	 int sacs = this.pb.getNbSacs();
	 int objets = this.pb.getNbObjets();
       
	 //si le dernier élément n'est pas dans le dernier sac , on le déplace dans le sac suivant 
	 if (this.repartition[objets -1] != sacs) {
		 this.repartition[objets -1]++;
	 }
	 //sinon 
	 else {
		 //on replace le dernier sac dans le premier 
		 this.repartition[objets -1] = 1;
		 int ret = 1; 
		 int cpt = objets -2;
		 //tant que tous les objets n'ont pas été décalés correctement on continue
		 while (ret == 1 && cpt > 0) {
			 this.repartition[cpt]++;
			 //si un objet est dans un sac qui n'existe pas on le replace dans le premier
			 if (this.repartition[cpt] > sacs) {
				 this.repartition[cpt] = 1;
				 cpt--;
			 }
			 //sinon on a bien décalé et on arrete la boucle 
			 else {
				 ret = 0;
			 }
		 }
	 }
   }
 
 public boolean estDernier() {
  	
	 //pour chaque objet on vérifie qu'il se trouve bien dans le dernier sac 
	 for (int i = 0 ; i < this.repartition.length ; i++) {
		 if (this.repartition[i] != this.pb.getNbSacs()) {
			 return false;
		 }
	 }
	 
	 return true; 
  }
 
 private int generateRandom(int max) {
	 double tmp = Math.random();
	 return (int) Math.floor(tmp * max) +1 ;
 }
    
 public void alea() {
   	int cpt = this.pb.getNbObjets();
   	//tant que tous les objets n'ont pas été placés
   	while (cpt > 0) {
   		//on tire un nombre entre 1 et n
   		int objet = generateRandom(this.pb.getNbObjets() - 1);
   		
   		//si l'objet n'a pas déjà été placé dans un sac
   		if (this.repartition[objet -1] == 0) {
   			
   			//on tire un nombre entre 1 et k
   			int sac = generateRandom(this.pb.getNbSacs() - 1);
   			
   			//on place l'objet dans le sac k et on indique qu'il y a un objet de moins à placer 
   			this.repartition[objet -1] = sac;
   			cpt--;
   		}
   	}
 }
    
 public void affiche() {
 	for (int i = 0 ; i < this.repartition.length ; i++) {
 		System.out.print("L'objet ");
 		System.out.print(i+1);
 		System.out.print(" a été placé dans le sac ");
 		System.out.print(this.repartition[i]);
 		System.out.println();
 	}
 }
    
}
