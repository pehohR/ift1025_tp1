1 - Si un ou plusieurs attributs n’ont pas été spécifié avant l’appel à creerPlante, vous devez lancer une exception
avec de créer l’instance. Suggérez dans votre README.txt deux façons de garder une trace de quels attributs ont
été initialisés. La-quelle avez-vous choisie et pourquoi ?

1- Créer un compteur qui compte le nombre d'attributs initialisés. Lancer l'exception si la valeur du compteur est
inférieure aux nombre d'attributs nécessaires.

2- Attribuer une valeur booléenne à chaque attributs. Lancer l'exception si au moins un des booléens est «false».

Nous avons choisi la deuxième méthode car elle permet de valider individuellement chacun des attrivbuts et permettrait,
si on le souhaite, de spécifier quels attributs sont manquants