Mercier Tony
Jones Marie

#### TP3 : Propriétés NP et réductions polynomiales

### Propriété NP

## Question 1 :

Un certificat correspond ici à une répartition des n objets dans les k sacs.
Une implémentation possible est un tableau à k cases représentant les sacs et qui contient les objets
Donc la taille d'un certificat est au plus k.

# Algo de vérification

    entrée : un tableau tab de taille k, un entier c , un entier nb
    sortie : vrai si la répartition est correcte , faux sinon

    debut

        soit n un entier = 0;

        pour i allant de 0 à k-1 faire

            faire la somme des poids pour k[i]

            si somme > c alors
                retourner faux
            fin si

            n += nombre d'objets contenus dans le sac
        fin pour

        si n != nb alors
            retourner faux
        sinon
            retourner vrai

        fin si

    fin


## Question 2 :

#2.1

Idée :
    on utilise une stratégie gloutonne

    1) on tire un nombre au hasard entre 1 et n => correspond à l'objet qu'on va placer
    2) on tire un nombre au hasard entre 1 et k => correspond au sac 
    3) on place l'objet dans le sac 
    4) on recommence tant que tout les objets n'ont pas été placés

On a une chance sur k de placer l'objet dans le sac i. De plus on a une chance sur n de prendre l'objet j. 
Chaque certificat a la probabilité 1/n*k + 1/(n-1) *k + ...+ 1/k d'apparaître 

#2.2

Idée :
      Tant que le certificat n'est pas valide ou qu'une limite est atteinte
            Génération aléatoire d'un certificat
            Vérification du certificat avec l'algorithme de vérification
      fin tant que

      si le certificat est valide
            retourner le certificat
      sinon
            retourner faux // Aucun certificat ne peut résoudre le problème


Idée de limite pour arrêt de l'algorithme :
  1) Arrêt de l'algo suite à une limite de temps dépassée
  2) Arrêt de l'algo suite à un nombre d'essai limite dépassé (ex : k^nb)


## Question 3 :

#3.1
Pour n fixé, un certificat peut prendre k^n valeurs

#3.2
