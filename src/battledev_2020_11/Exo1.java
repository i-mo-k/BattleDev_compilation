package battledev_2020_11;

import java.util.Scanner;

/*
Bienvenue sur cette nouvelle �dition de la BattleDev !

Le temps d'une soir�e, vous incarnez Jean-Claude Van Debunk, un des plus grands journalistes d'investigations du XXIe si�cle.

Votre nouvelle enqu�te ? Vous cherchez la source d'une vague de fake news sans pr�c�dent, cherchant � d�stabiliser les �lections prochaines en Russie. Et vous pensez avoir une excellente piste, qui pourrait mener aux plus grandes r�v�lations de votre carri�re !

Plusieurs sources vous ont indiqu� qui serait � la t�te de ce puissant r�seau : un myst�rieux Dolan Grump.

Pr�t.e � d�masquer Dolan et d�manteler son r�seau ? Il n'y a pas de temps � perdre, les fake news continuent d'arriver par millions !


Objectif

Apr�s de longues recherches ous avez r�ussi � trouver le compte Twitter de Dolan : @DolanGrump ! Vous d�cidez de vous int�resser � ses millions de followers : vu le nombre de retweets sur chaque article partag�, vous suspectez grandement que beaucoup de ces followers sont en r�alit� des bots...

Vous d�cidez de faire une premi�re analyse pour identifier les potentiels bots : vous remarquez que la plupart des bots ont un nom de compte ne terminant que par des chiffres, contrairement aux comptes de personnes r�elles.

Ecrivez un algorithme permettant de d�terminer les comptes suspects. Un compte est suspect s'il se termine par 5 chiffres.

Donn�es

Entr�e

Ligne 1 : un entier N compris entre 1 et 1000, repr�sentant le nombre de comptes � v�rifier
Lignes 2 � N+1 : une cha�ne de caract�res (compos�e uniquement de chiffres et de lettres et d'une longueur comprise entre 6 et 15 caract�res) repr�sentant le nom d'un compte � examiner.

Sortie

Un entier repr�sentant le nombre de comptes suspects parmi la liste donn�e en entr�e.
Un compte est consid�r� comme suspect s'il se termine par 5 chiffres.

Exemple

Pour l'entr�e :

6
h25io
gn0mi12345
realDon4321
yaNNd3v
cup0ft3444455
bienvenueCorbier
BClukschoco


Votre programme doit renvoyer :
2
Effectivement, les comptes cup0ft3444455 et gn0mi12345 sont suspects, pas les autres.
 * */

public class Exo1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String  line;
		Scanner sc = new Scanner(System.in);
		int counter = 0, index = 0, accountCount = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* si index = 1
			 * 		choper le nombre de lignes � lire
			 * sinon
			 * 		lire le mot et regarder si �a matche regex
			 * 		si oui
			 * 			compteur +1
			 * index +1 */
			if (index == 0) {
				accountCount = Integer.parseInt(line);
			} else {
				if (index <= accountCount && checkLine(line)) {
					counter ++;
				}
			}
			index ++;
		}
	/* balancer compteur*/
		System.out.println(counter);
	}

	private static boolean checkLine(String line) {
		return line.substring(line.length() - 5).matches("[0-9]{5}");
	}

}
