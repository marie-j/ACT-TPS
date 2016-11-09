Mercier Tony
Jones Marie 

#### TP3 : Propriétés NP et réductions polynomiales

### Propriété NP 

## Question 1 : 

Un certificat correspond ici à une répartition des n objets dans les k sacs.
Une implémentation possible est un tableau à k cases représentant les sacs et qui contient les objets et leur poids 

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

    1) on tire un nombre au hasard entre 1 et n => correspond à l'objet qu'on va placer dans le premier sac
    2) on continue jusqu'à ce que le sac soit plein
    3) on fait de même avec les autres sacs 
    4)on vérifie avec l'algo de vérification que le résultat est correct 
        5) a . Il est correct => on retourne la solution
        5) b. Il n'est pas correct => on recommence 



