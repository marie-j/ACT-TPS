Mercier Tony
Jones Marie 

# Heuristiques 

## Certificat et validation 

### 2.1

Une représentation possible est une découpe possible de la pizza. 
On peut alors représenter une découpe par une liste (de taille au max h*l) contenant les parts. Une part étant représentée par une liste de cases.  


### 2.2

taille de l'entrée : h*l 
taille de la représentation (dans le pires des cas) : 
* si on remplit toute la liste : on aura des listes de 1 seul élément donc h * l *1 
* si on remplit on a qu'une seule part : on aura une liste avec tous les éléments donc h * l * 1

|représentation| <=|entrée|

### 2.5

Dans le pire des cas on aura h*l opérations:
* si on a h*l parts : donc on parcourera la première liste (première boucle) ce qui prendra h * l opérations mais on effectuera pas le parcours de la liste imbriquée ( puisque on ne prendra en compte que un seul élément)
* si on a 1 part : on parcourera la première liste une seule fois et la seconde h * l fois

### 2.6 

Pour trouver une solution à ce problème, il faudrait parcourir tous les certificats. 
Si on en trouve un correspondant on arrête le parcours mais si il n'y a pas de solutions il faudra parcourir tous les certificats. 

