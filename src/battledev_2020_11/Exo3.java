package battledev_2020_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Une fois les comptes suspects identifiés, vous découvrez que les agents s'organisent comme un réseau tentaculaire qui semblent être organisés de manière hiérarchique avec Dolan à sa tête !

Chaque compte, à l'exception de Dolan, est placé sous la supervision d'un unique supérieur hiérarchique. Afin de mieux comprendre le fonctionnement de ce réseau et pour vous faire passer pour l'un d'entre eux, vous allez devoir produire une analyse du groupe à partir de ces liens hiérarchiques.

Les agents de niveau 2 sont ceux placés directement sous Dolan Grump. Les agents de niveau 3 sont ceux dont le supérieur est de niveau 2, et ainsi de suite.

Vous devez identifier combien d'agents appartiennent à chaque niveau de la hiérarchie.


Données

Entrée

Ligne 1 : Le nombre d'agents dans le réseau N, compris entre 1 et 1000
Lignes 2 à N : deux entiers A et B séparés par un espace, signifiant que l'agent B est le supérieur de l'agent A.

Sortie

10 entiers séparés par des espaces, représentant le nombre d'agents de chaque niveau entre 1 et 10.

Notes :
- Il y a au maximum 1000 agents dans le réseau
- Aucun agent n'a un niveau de plus de 10
- Chaque agent a exactement un supérieur, à l'exception de Dolan qui n'en a pas
- Dolan Grump est représenté par l'entier 0, et est toujours le seul au niveau 1

Exemple

Pour l'entrée :
5
1 4
3 1
4 0
2 4

La réponse devra être :
1 1 2 1 0 0 0 0 0 0
 * */

public class Exo3 {
	
	@SuppressWarnings("resource")
	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		int index = 0, n = 0;
		Map<String, List<String>> tree = new HashMap<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			/* si index = 0
			 * 		lire N
			 * sinon
			 * 		si index <= N
			 * 			si agent B n'existe pas
			 * 				créer B et initialiser sa liste
			 * 			dans B mettre l'enfant A
			 * index ++ */
			if (index == 0) {
				n = Integer.parseInt(line);
			} else {
				if (index <= n) {
					String[] split = line.split(" ");
					String child = split[0];
					String parent = split[1];
					if (!tree.containsKey(parent)) {
						tree.put(parent, new ArrayList<>());
					}
					tree.get(parent).add(child);
				}
			}
			index ++;
		}
		/*
		 * initialiser liste(int) avec 1
		 * stocker enfants de "0" dans liste et ajouter dans liste(int) le nombre de ses enfants
		 * retirer "0" de map
		 * tant que map non vide faire
		 * 		initaliser compteur = 0 et tempList(enfants)
		 * 		pour chaque enfant dans liste,
		 * 			compteur += le nombre d'enfants de l'enfant
		 * 			ajouter ces enfants dans tempList
		 * 			retirer enfant de map
		 * 		ajouter compteur dans liste(int)
		 * 		remplacer liste par tempList
		 */
		List<Integer> countList = new ArrayList<>();
		List<String> childLevel = tree.get("0");
		tree.remove("0");
		countList.add(childLevel.size());
		do {
			List<String> temp = new ArrayList<>();
			for (String child : childLevel) {
				List<String> grandChildren = tree.get(child);
				if (grandChildren != null) {
					temp.addAll(grandChildren);
				}
			}
			tree.keySet().removeAll(childLevel);
			countList.add(temp.size());
			childLevel = temp;
		} while (!tree.isEmpty());
		while (countList.size() < 9) {
			countList.add(0);
		}
		StringBuilder sb = new StringBuilder("1");
		for (Integer number : countList) {
			sb.append(" " + number);
		}
		
		System.out.println(sb.toString());
	}
}
