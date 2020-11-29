package battledev_2020_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
	
	static final long LAMBDA = 4294967296l, MIN = 33, MAX = 126, DIV = 31;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String  line;
		Scanner sc = new Scanner(System.in);
		long sigma = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.err.println("line = " + line);
			sigma = modulo(line) + LAMBDA;
			/* changer le line en chaine d'entier ascii
			 * calculer la somme totale et la valeur cible
			 * 		-> remplacé par son modulo pour l'espace
			 * calculer sigma la nouvelle somme avec lambda */
		}
		/* tant que sigma n'est pas comprise entre 33 et 126,
		 * 		calculer le reste de sigma par le diviseur
		 * 		tant que u n'est pas compris entre 33 et 126
		 * 			u = u + diviseur
		 * 		ajouter u à la liste
		 * 		sigma = (sigma - u) / diviseur
		 * retourner la liste
		 * convertir en ascii
		 * sb */
		List<Long> inverseList = new ArrayList<>();
		System.err.println("sigma = " + sigma);
		while (sigma > MAX) {
			long u = sigma % DIV;
			while (u < MIN) {
				u += DIV;
			}
			inverseList.add(u);
			System.err.println("u = " + u);
			sigma = (sigma - u) / DIV;
			System.err.println("sigma = " + sigma);
		}
		inverseList.add(sigma);
		System.out.println(inverseToASCII(inverseList));
	}

	private static long modulo(String line) {
		char[] charArray = line.toCharArray();
		int n = charArray.length;
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += ((long) charArray[n - i - 1] * powerFacto(i) % LAMBDA) % LAMBDA;
		}
		return result % LAMBDA;
	}

	private static long powerFacto(int i) {
		if (i == 0) {
			return 1;
		}
		if (i == 1) {
			return DIV;
		}
		if (i % 2 == 0) {
			return ((powerFacto(i / 2) % LAMBDA) * (powerFacto(i / 2) % LAMBDA) % LAMBDA);
		}
		return DIV * ((powerFacto(i / 2) % LAMBDA) * (powerFacto(i / 2) % LAMBDA) % LAMBDA);
	}

	private static String inverseToASCII(List<Long> inverseList) {
		StringBuilder sb = new StringBuilder();
		for (int i = inverseList.size() - 1; i >= 0; i--) {
			sb.append((char) (long) inverseList.get(i));
		}
		return sb.toString();
	}
}
