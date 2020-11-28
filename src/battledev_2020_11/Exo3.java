package battledev_2020_11;

import java.util.Scanner;

/*
 * Une fois les comptes suspects identifi�s, vous d�couvrez que les agents s'organisent comme un r�seau tentaculaire qui semblent �tre organis�s de mani�re hi�rarchique avec Dolan � sa t�te !

Chaque compte, � l'exception de Dolan, est plac� sous la supervision d'un unique sup�rieur hi�rarchique. Afin de mieux comprendre le fonctionnement de ce r�seau et pour vous faire passer pour l'un d'entre eux, vous allez devoir produire une analyse du groupe � partir de ces liens hi�rarchiques.

Les agents de niveau 2 sont ceux plac�s directement sous Dolan Grump. Les agents de niveau 3 sont ceux dont le sup�rieur est de niveau 2, et ainsi de suite.

Vous devez identifier combien d'agents appartiennent � chaque niveau de la hi�rarchie.


Donn�es

Entr�e

Ligne 1 : Le nombre d'agents dans le r�seau N, compris entre 1 et 1000
Lignes 2 � N : deux entiers A et B s�par�s par un espace, signifiant que l'agent B est le sup�rieur de l'agent A.

Sortie

10 entiers s�par�s par des espaces, repr�sentant le nombre d'agents de chaque niveau entre 1 et 10.

Notes :
- Il y a au maximum 1000 agents dans le r�seau
- Aucun agent n'a un niveau de plus de 10
- Chaque agent a exactement un sup�rieur, � l'exception de Dolan qui n'en a pas
- Dolan Grump est repr�sent� par l'entier 0, et est toujours le seul au niveau 1

Exemple

Pour l'entr�e :
5
1 4
3 1
4 0
2 4

La r�ponse devra �tre :
1 1 2 1 0 0 0 0 0 0
 * */

public class Exo3 {
	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les donn�es et effectuez votre traitement */
		}
		/*
		 * Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes
		 * les donn�es.
		 */
	}
}
