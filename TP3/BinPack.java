/******************************************************************
La classe abstraite des problèmes de décision, pbs de type Oui/non
******************************************************************/

.....abstract class PblDec{

public PblDec(){};

abstract public boolean aUneSolution();
}

/**********************************************************************
****************La classe des problèmes BinPack************************
**********************************************************************/

.....class PblBinPack extends PblDec
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
    public boolean aUneSolution() {
	 //  A compléter
      // essaie tous les certificats un à un jusqu'à en trouver un correct -si il existe	....
    }
    
    //Algo non déterministe
    //si il y aune solution, au moins une exécution doit retourner Vrai
    // sinon, toutes les exécutions doivent retourner Faux
    public boolean aUneSolutionNonDeterministe() {
	//   A compléter
    //génère alétaoirement un certificat et vérifie si il est correct
    }

   // différents accesseurs, fonctions affichage ...}

/**********************************************************************
****************l'interface Certificat*********************************
Un certificat est associé à un problème.
la taille d'un certificat doit être bornée polynomialement par rapport au problème
**********************************************************************/
    
{
 /*retournera vrai SSi le certificat est bien correct pour le pb auquel il est associé - l'algorithme A du cours  */
  
 public boolean estCorrect();
 
 //pour pouvoir enumérer les certificats, on définit un ordre sur les certificats
 //le certificat passe au suivant dans l'ordre choisi
 public void suivant();
 //le certificat est le dernier dans l'ordre choisi
 public boolean estDernier();
 
 //le certificat prend une valeur alétaoire
 public void alea();
 
 public void affiche();
}
 
    
/************************************************************************
**************** Les certificats pour BinPack****************************
************************************************************************/
 
.... class CertificatBinPack implements Certificat
{private PblBinPack pb;
 //	//   A compléter ... votre représenttaion du certificat

 public CertificatBinPack(PblBinPack p) {
  // 	//   A compléter
 }
    
 public CertificatBinPack(PblBinPack p, int[] aff) {
      // 	//   A compléter.. construit en fonction des choix de l'utilisateur
    } 
    
  //Implémnetation del'interface:
    
 public boolean estCorrect(){
  	//   A compléter
  }

 public void suivant() {
    //   A compléter
   }
 
 public boolean estDernier() {
  	//   A compléter
  }
    
 public void alea() {
   	//   A compléter
 }
    
 public void affiche() {
 	//   A compléter
 }
    
}
/*************************************************************************
********************************Pour Tester ******************************
**************************************************************************/
    
.... class ... {
public static void main(String[] args) throws Exception {
    if (args.length < 3){
	    System.out.println("Usage: java testBinPack <file> <mode> <nbsacs>");
		System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}
	else {
		BufferedReader donnee  //le fichier qui contient les données du pb
        = new BufferedReader (new FileReader(args[0]));
        int cap=Integer.parseInt(donnee.readLine());
        int nbObjets=Integer.parseInt(donnee.readLine());
        int poids[]=new int[nbObjets];
        for (int i=0;i< nbObjets;i++) poids[i]=Integer.parseInt(donnee.readLine());
        int nbSacs=Integer.parseInt(args[2]);
        PblBinPack pb=new PblBinPack(nbObjets,poids,nbSacs,cap);
        if (args[1].equals("-exh")) System.out.println(pb.aUneSolution());
        else if (args[1].equals("-nd")) System.out.println(pb.aUneSolutionNonDeterministe());
        else if (args[1].equals("-ver")) {
            BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
            int aff[]=new int[nbObjets];
            for (int i=0;i < nbObjets; i++) {
                System.out.print("donnez un no de sac de 1 a "); System.out.println(nbSacs);
                System.out.print("pour l'objet "); System.out.println(i);
                aff[i]=Integer.parseInt(entree.readLine());
                if (aff[i]<0 || aff[i]>=nbSacs) throw new Exception("valeur non autorisee");}
            Certificat cert =new CertificatBinPack(pb,aff); //constructeur qui affecte aux sacs les valeurs de aff;
            System.out.println(cert.estCorrect());
        }
        else {
            System.out.println("Usage: java  testBinPack <file>  <mode> <nbsacs>");
            System.out.println("where modes include: -ver (verif), -nd (non déterministe), -exh (exhaustif)");}

 	}
}
}
