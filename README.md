# usine
Projet jeu usine Licence 3 en binôme.

* La partie modèle à été faite par Julien Pivard.
* La partie interface graphique à été faite par ma binome.

##Compilation
La compilation se fait grâce à l'utilitaire _ant_.
####Logiciel et compilateur utilisé
* _ant_;
* _openjdk-7-jdk_

####Compilation rapide
Pour une compilation rapide qui ne génère pas de **jar**,
Il faut taper la commande suivante dans un terminal en se plaçant à la racine du projet :
* _ant compile_
* puis _ant run_ pour exécuter le build.

####Compilation du jar
Pour générer le **jar**,
il faut exécuter la commande suivante dans un terminal en se plaçant à la racine du projet :
* _ant compilejar_
* puis _ant runjar_ pour exécuter le **jar**.

Le **jar** généré se situe dans le dossier _dist_.
