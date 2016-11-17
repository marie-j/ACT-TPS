Mercier Tony
Jones Marie

#### TP3 : Propriétés NP et réductions polynomiales

### Propriété NP

## Question 1 :

Un certificat correspond ici à une répartition des n objets dans les k sacs.
Une implémentation possible est un tableau à k cases représentant les sacs et qui contient les objets et leur poids
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

# 2.1

Idée :
    on utilise une stratégie gloutonne

    1) on tire un nombre au hasard entre 1 et n => correspond à l'objet qu'on va placer dans le premier sac
    2) on continue jusqu'à ce que le sac soit plein
    3) on fait de même avec les autres sacs
    4)on vérifie avec l'algo de vérification que le résultat est correct
        5) a . Il est correct => on retourne la solution
        5) b. Il n'est pas correct => on recommence

Du fait que les sacs ont tous la même capacité, chacun d'entre eux a la même probabilité d'avoir une certaine combinaison d'objets. Par conséquent, chaque certificat à la même probabilité d'apparaître.

# 2.2

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

# 3.1
Pour n fixé, un certificat peut prendre k^n valeurs

# 3.2

Le plus petit : tous les objets sont dans le sac le plus à gauche 
Le max : tous les objets sont dans le sac le plus à droite 
Successeur : - on passe l'objet avec l'indice du plus grand au sac suivant 
                si il est dans le dernier sac : on le remet dans le premier et c'est l'avant-dernier qui est décalé 
                si l'avant-dernier est dans le dernier sac : on le remet dans le premier et c'est son précédent qui est décalé
                etc ... 

# 3.3

    début : donnée BinPack 
    sortie : Oui si il y aun certificat , non sinon 

    debut 
        certificat = premier certificat
        
        tant que (certificat a un suivant) faire 
            
            si algo de verificaton pour le certificat renvoie vrai alors
                retourner le certificat
            sinon 
                passer au certificat suivant
            fin si 

        fin tant que 

        vérifier le dernier certificat
        
        si valide
            le retourner
        sinon 
            retourner faux; 
        fin si 
    
    fin 

Complexité de l'algo : k^n
    Dans le pire des cas on va parcourir tous les certificats. 



