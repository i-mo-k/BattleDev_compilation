package battledev_2020_11;

/*
 * En interceptant les messages du réseau de Dolan Grump, vous êtes parvenu à obtenir le lien vers une plateforme qui semble coordonner les actions de fake news. Malheureusement, la création de compte invité ne vous permet pas d'accéder aux contenus les plus intéressants du site, il va falloir ruser pour obtenir les bonnes autorisations...

Avec vos talents de hacker amateur, vous identifiez une vulnérabilité dans le site : le calcul de l'identifiant d'un utilisateur est effectué via un hachage simple de son pseudonyme. En faisant en sorte que votre hash soit le même que celui d'un chef de réseau, vous parviendrez sûrement à usurper son identité lors du calcul des permissions !

La fonction de hachage d'une chaîne S de longueur N est la suivante :

hash(S) = (S_0 * 31^(N-1) + S_1 * 31^(N-2) + ... + S_N-2 * 31 + S_N-1) % 4294967296, où S_i est le code ASCII du caractère de S à l'index i.


Données

Entrée

Ligne 1 : une chaîne de caractères de longueur 5 à 50, le pseudonyme du chef de réseau.

Sortie

Une chaîne de longueur 1 à 100, le pseudonyme que vous choisissez de telle sorte que le hash de votre pseudonyme soit le même que celui du chef de réseau.

Contraintes

- Les chaînes de caractère en entrée et en sortie ne peuvent être composées que de caractères imprimables hors espace (codes ASCII entre 33 et 126 inclus).

- Si plusieurs réponses valides existent, vous pouvez utiliser n'importe laquelle.

- Votre pseudonyme doit être différent de celui du chef de réseau.


Exemple

Si le chef de réseau a le pseudo BigBoss, son hash vaut (66 * 31^6 + 105 * 31^5 + 103 * 31^4 + 66 * 31^3 + 111 * 31^2 + 115 * 31 + 115) % 4294967296 = 1548960877

En choisissant le pseudonyme Coolh4cker0780578, votre hash sera également 1548960877, donc cette solution est valide (parmi de nombreuses autres).
 * */

public class Exo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
