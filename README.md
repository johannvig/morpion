# Projet Morpion en JavaFX
Ce projet est un simple jeu de Morpion développé en JavaFX pour la première année de BUT informatique. Le Morpion est un jeu de stratégie simple joué sur une grille carrée de 3x3.

Prérequis
Pour exécuter ce projet, vous aurez besoin de Java et JavaFX installés sur votre machine.

## Utilisation
L'objectif du jeu de Morpion est d'aligner trois de vos marques dans une ligne horizontale, verticale ou diagonale. Les joueurs alternent les tours. Vous jouez contre l'ordinateur dans cette version du jeu.

## Créer un fichier .jar
Pour plus d'informations sur comment créer un fichier .jar, veuillez consulter cette vidéo : [Créer un fichier .jar](https://www.youtube.com/watch?v=_XQjs1xGtaU)

ou suivre ces instructions :

### Pour créer un fichier .jar à partir de votre projet JavaFX dans IntelliJ IDEA, suivez les étapes suivantes :

1. Ouvrez votre projet JavaFX dans IntelliJ IDEA.

2. Allez à File > Project Structure (ou utilisez le raccourci Ctrl+Alt+Shift+S).

3. Dans la fenêtre qui s'ouvre, cliquez sur Artifacts dans le menu de gauche.

4. Cliquez sur le bouton + en haut de la fenêtre, puis sélectionnez JAR > From modules with dependencies.

5. Une nouvelle fenêtre s'ouvrira. Sélectionnez le module de votre projet et le fichier principal (Main) de votre application.

6. Cliquez sur OK. Vous retournerez à la fenêtre Project Structure.

7. Dans cette fenêtre, sous l'onglet Output Layout, assurez-vous que tous vos fichiers .jar et autres ressources sont inclus (comme vos fichiers .fxml et .css, si vous en avez).

8. Cliquez sur OK pour fermer la fenêtre Project Structure.

9. Maintenant, allez à Build > Build Artifacts...

10. Dans le menu déroulant, sélectionnez votre artifact, puis cliquez sur Build.

11. IntelliJ IDEA créera un fichier .jar pour votre projet dans le dossier out/artifacts/ de votre projet. Vous pouvez exécuter le fichier .jar avec la commande java -jar nom_du_fichier.jar.

Notez que pour exécuter correctement le fichier .jar, vous aurez besoin de la bibliothèque JavaFX et vous devrez peut-être configurer votre variable d'environnement PATH_TO_FX pour indiquer l'emplacement de cette bibliothèque. De plus, le fichier .jar doit être exécuté avec des arguments supplémentaires pour inclure le module JavaFX. Voici un exemple de commande : java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -jar nom_du_fichier.jar.
