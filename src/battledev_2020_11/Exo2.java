package battledev_2020_11;

import java.util.Scanner;

/*
 * Vous commencez � y voir plus clair ! Dolan semble bien faire partie d'un immense r�seau d'influenceurs malintentionn�s... Gr�ce � votre analyse pr�c�dente, vous savez quels comptes cibler pour votre enqu�te.

Vous essayez maintenant de r�v�ler au grand jour les principaux acteurs des manipulations que subissent des �l�ctions en Russie. Apr�s avoir identifi� les comptes suspects, vous vous penchez maintenant sur leurs tweets.

Vous trouvez une bonne m�thode pour distinguer les comptes qui sont effectivement russes des comptes dangeureux : si le compte publie trop de contenu la nuit (heure russe), alors c'est tr�s probablement le compte d'un agent.

A partir de la liste des heures de publication d'un compte (les heures sont d�j� converties en heure russe), d�terminez si ce compte a plus d'activit� la nuit que le jour. Si plus de 50% des tweets sont entre 20h et 8h, alors c'est un compte de fake news.


Donn�es

Entr�e

Ligne 1 : un entier N compris entre 5 et 1000, repr�sentant le nombre de publications faites par le compte � examiner.
Lignes 2 � N+1 : une cha�ne de caract�res de la forme hh:mm repr�sentant l'heure d'une publication

Sortie

Votre programme devra renvoyer une seule ligne : SUSPICIOUS si le compte est suspect, OK sinon.

Un compte est consid�r� suspect si plus de la moiti� des publications sont faites la nuit (entre 20:00 et 7:59 compris). Il est garanti qu'aucun compte n'a autant de publications la nuit que le jour.


Exemple

Pour l'entr�e :

5
20:04
20:23
08:00
09:15
13:00


Votre code devra renvoyer : OK
En effet, seulement 2 publications ont �t� faites la nuit sur ce compte.

Pour l'entr�e :

5
20:00
00:29
22:58
15:06
17:50


Votre code devra renvoyer : SUSPICIOUS
 * */

public class Exo2 {

	public static void main(String[] args) {
		String  line;
		Scanner sc = new Scanner(System.in);
		double counter = 0, index = 0, postCount = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* si index = 1
			 * 		choper le nombre de lignes � lire
			 * 		calculer le nombre minimal de suspicious-posts
			 * sinon
			 * 		lire le mot et regarder si apr�s 20h ou avant 8h dans la journ�e
			 * 		si oui
			 * 			compteur +1
			 * 			si compteur > nombre minimal d�fini
			 * 				s'arr�ter et dire suspicieux
			 * index +1 */
			if (index == 0) {
				postCount = Double.parseDouble(line);
			} else {
				if (index <= postCount && checkLine(line)) {
					counter += 1 / postCount;
					if (counter > 0.5) {
						System.out.println("SUSPICIOUS");
						return;
					}
				}
			}
			index ++;
		}
	/* dire ok */
		System.out.println("OK");
	}

	private static boolean checkLine(String line) {
		return (line.compareTo("08:00") < 0) || (line.compareTo("20:00") >= 0);
	}

}
