package battledev_2020_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Apr�s avoir correctement rep�r� la structure du r�seau, vous acc�dez � un salon priv� de discussion dont le contenu est chiffr� de mani�re tr�s �trange : chaque message peut �tre d�chiffr� en effectuant plusieurs op�rations sur une cl� initiale de N octets partag� entre tous les utilisateurs.

Chaque octet du message est calcul� avec une op�ration d�crite par deux entiers L et R (avec L <= R). Le r�sultat de l'op�ration est �gal � (cl�[L] XOR cl�[L+1] XOR cl�[L+2] .... XOR cl�[R-1] XOR cl�[R]), o� XOR d�note l'op�ration Ou Exclusif sur des nombres entiers.

Dans certains cas, le message semble trop lent � reconstituer m�me avec vos ordinateurs les plus performants, alors que les t�l�phones des membres du r�seau semblent pouvoir faire ces m�mes op�rations en une fraction de seconde. Pouvez-vous impl�menter cet algorithme de mani�re efficace afin de d�chiffrer les messages �chang�s � partir de la cl� et de la liste des op�rations � effectuer ?


Donn�es

Entr�e

Ligne 1 : deux entiers N et M (avec 0 <= N, M <= 100 000), respectivement la taille de la cl� et la taille du message

Ligne 2 : N entiers entre 0 et 255 s�par�s par des espaces, les octets de la cl�

Lignes 3 � M+2 : A la ligne i, eux entiers Li et Ri (avec 0 <= Li <= Ri <= N-1) correspondant � l'op�ration � effectuer pour retrouver l'octet i du message

Sortie

1 ligne avec 256 entiers N0 N1 ... Ni ... N255 s�par�s par des espaces, Ni �tant le nombre de i dans le message d�chiffr�.


Attention : les entr�es �tant d'une taille importante, une solution na�ve pourrait fonctionner sur les premiers jeux de test (plus petits) mais ne pas �tre suffisante pour les plus gros jeux de test. Il faudra redoubler d'ing�niosit� pour d�chiffrer les messages !


Exemple

Pour l'entr�e :
5 4
11 22 33 44 55
1 3
0 1
2 2
2 4

Le r�sultat de chaque op�ration affich� par votre code sera le suivant :

0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

En effet :
22 xor 33 xor 44 = 27
11 xor 22 = 29
33 = 33
33 xor 44 xor 55 = 58

Le message d�chiffr� est donc : 27 29 33 58, d'o� la sortie attendue
 * */

public class Exo4 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String  line;
		Scanner sc = new Scanner(System.in);
		int index = 0, n = 0;
		List<Integer> keys = new ArrayList<>();
		Map<Integer, Integer>result = new HashMap<>();
		int maxXor = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* si index = 0 lire m et n
			 * si index = 1 stocker les cles
			 * sinon
			 * 		pour chaque indice
			 * 			calcul et stockage de xor  */
			if (index == 0) {
			} else if (index == 1) {
				for (String string : line.split(" ")) {
					keys.add(Integer.parseInt(string));
				}
				maxXor = xor(keys);
				n = keys.size();
			} else {
				String[] split = line.split(" ");
				int min = Integer.parseInt(split[0]);
				int max = Integer.parseInt(split[1]);
				int res = 0;
				if (max - min < n / 2) {
					res = xor(keys.subList(min, max + 1));
				} else {
					res = maxXor
							^ xor(keys.subList(0, min))
							^ xor(keys.subList(max + 1, keys.size()));
				}
				if (!result.containsKey(res)) {
					result.put(res,  0);
				}
				result.put(res, result.get(res) + 1);
			}
			index ++;
		}
	/* initialiser sb
	 * pour i de 0 � 255
	 * 		si map contient i, stocker sa valeur
	 * 		sinon stocker 0 */
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			if (result.containsKey(i)) {
				sb.append(result.get(i) + " ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static int xor(List<Integer> keys) {
		if (keys.isEmpty()) return 0;
		if (keys.size() == 1) return keys.get(0);
		if (keys.size() == 2) return keys.get(0) ^ keys.get(1);
		Map<Integer, Integer> temp = new HashMap<>();
		for (Integer integer : keys) {
			if (integer != 0) {
				if (!temp.containsKey(integer)) {
					temp.put(integer, 0);
				}
				temp.put(integer, temp.get(integer) + 1);
			}
		}
		boolean paired = true;
		int toPair = 0;
		List<Integer> list = new ArrayList<>();
		for (Integer key : temp.keySet()) {
			if (temp.get(key) % 2 == 1) {
				if (paired) {
					toPair = key;
					paired = false;
				} else {
					list.add(toPair ^ key);
					paired = true;
				}
			}
		}
		if (!paired) {
			list.add(toPair);
		}
		return xor(list);
	}
}