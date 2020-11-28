package battledev_2020_11;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
