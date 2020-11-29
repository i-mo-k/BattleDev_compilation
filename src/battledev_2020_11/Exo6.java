package battledev_2020_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Maintenant que vous avez d�chiffr� toutes les communications du r�seau de fake news, vous avez pr�venu les autorit�s comp�tentes. Malheureusement, ces autorit�s ne sont pas suffisamment comp�tentes pour arr�ter le r�seau de fake news � temps pour les �lections de 2022. Vous devez donc prendre les choses en main pour emp�cher les fake news de se r�pandre.

Pour chacun des N articles de fake news sortis au cours des derniers mois, vous avez un article de debunk sorti � la m�me p�riode. Un article est repr�sent� par une string S = S[1]...S[|S|] repr�sentant une suite de sujets. Chaque caract�re de la cha�ne de caract�res repr�sente donc un sujet, et un m�me sujet peut �tre trait� plusieurs fois dans un article (avec des arguments diff�rents).

Pour ne pas surcharger le cerveau des lecteurs et des lectrices, chaque matin vous allez pouvoir choisir un article F de fake news et l'article D de debunk correspondant et faire un tweet T = [(a[1], b[1]), (a[2], b[2]), ..., (a[k], b[k])] mettant en �vidence k paires d'arguments trait�s dans les articles. Pour qu'un tweet soit frappant, il y a quelques r�gles � suivre :
- deux arguments compar�s (x, y) doivent correspondre au m�me sujet (F[x] = D[�y]);
- les arguments doivent �tre trait�s dans le m�me ordre que dans les articles (0<=a[1]
Votre strat�gie n'est pas pass�e inaper�ue, et la r�daction de fake news a d�cid� de faire exactement la m�me chose que vous. Ainsi, pour chaque tweet que vous ferez, ils feront aussi un tweet l'apr�s-midi, mais pas n�cessairement sur le m�me article.
Comme l'important est d'avoir le dernier mot, le premier ou la premi�re � ne plus pouvoir traiter d'un argument non d�j� trait� (qu'il ait �t� trait� par vous ou par eux) aura perdu de cette joute journalistique.

�tant donn� la liste des articles, d�terminez si vous pouvez �tre s�r(e) d'avoir le dernier mot.


Donn�es

Entr�e

Ligne 1 : Un entier N (avec 1 <= N <= 100), le nombre de paires d'articles que vous avez � disposition.

Lignes 2 � N+1 : deux cha�nes de caract�res F et D (avec 1 <= |F|,|D| <= 5) s�par�es par une espace et compos�es de lettres minuscules uniquement. Les caract�res de F et D repr�sentent les sujets de ces articles, et un m�me sujet peut �tre trait� plusieurs fois dans un article

Sortie

Le mot "DEBUNK" si vous pouvez �tre s�r d'avoir le dernier mot en tweetant en premier, sinon "FAKE".


Exemple

Pour l'entr�e :
2
cabc dbad
abab cdcd

Dans cet exemple, il n'y a pas d'argument en commun dans la deuxi�me paire d'article, on ne pourra donc pas tweeter dessus. Dans le premier par contre, il n'y a que 2 sous-suites de caract�res en commun : "a" et "b" (aucune sous-suite commune de 2 caract�re ou plus n'existe). Comme vous commen�ez � tweeter, on peut commencer par "a" et votre adversaire tweetera "b" (ou l'inverse), et nous aurons perdu. Ainsi, vous ne pourrez pas avoir le dernier mot et devez donc afficher :
FAKE

Pour l'entr�e :
2
cabc dbad
abcab abadb

Ici, vous pouvez commencer par tweeter "abab" dans la deuxi�me paire d'article. Il ne reste plus que "c" dans le premier article de cette paire, et "d" dans le second : ni vous ni votre adversaire ne pouvez donc tweeter un argument de cette paire d'articles. Votre adversaire se retrouve alors avec deux arguments restant ("a" et "b" de la premi�re paire d'articles), mais ne peut tweeter qu'� propos de l'un � la fois. Vous aurez donc le dernier mot et pouvez fi�rement afficher :
DEBUNK*/

public class Exo6 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String  line;
		int index = 0;
		int totalConfs = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.err.println(line);
			/*
			 * si index != 0
			 * 		ajouter me nombre de confrontations
			 * */
			if (index != 0) {
				totalConfs += confrontArticles(line);
			}
			index ++;
		}
	/* si impair, dire debunk
	 * si pair dire fake*/
		if (totalConfs % 2 == 0) {
			System.out.println("FAKE");
			return;
		}
		System.out.println("DEBUNK");
	}

	private static int confrontArticles(String line) {
		String[] split = line.split(" ");
		char[] fake = split[0].toCharArray();
		char[] debunk = split[1].toCharArray();
		
		List<Argument> fakeTopics = new ArrayList<>();
		List<Argument> debunkTopics = new ArrayList<>();
		for (int i = 0; i < fake.length; i++) {
			addNewArgument(String.valueOf(fake[i]), fakeTopics);
			addNewArgument(String.valueOf(debunk[i]), debunkTopics);
		}
		
		int commonCount = 0;
		/*
		 * pour la 1re lettre de fake
		 * 		si on trouve le mm arg,
		 * 			on retire lettre dans les deux listes
		 * 			on garde l'indice du 2nd et on continue � chercher tant qu'on arrive pas au bout
		 * 		sinon
		 * 			on retire lettre de la 1re liste*/
		while (!fakeTopics.isEmpty()) {
			if (containSimilarPattern(fakeTopics, debunkTopics)) {
				commonCount ++;
			}
			if (!fakeTopics.isEmpty()) {
				fakeTopics.remove(0);
			}
		}
		return commonCount;
	}

	private static void addNewArgument(String topic, List<Argument> fakeTopics) {
		int i = 0;
		for (Argument argument : fakeTopics) {
			if (argument.topic.equals(topic)) {
				i++;
			}
		}
		fakeTopics.add(new Argument(topic, i));
	}

	private static boolean containSimilarPattern(List<Argument> fakeTopics, List<Argument> debunkTopics) {
		boolean found = false;
		int index = 0;
		while (index < debunkTopics.size() && !fakeTopics.isEmpty()) {
			boolean corresponds = fakeTopics.get(0).
					correspondsTo(debunkTopics.get(index));
			found |= corresponds;
			if (corresponds) {
				fakeTopics.remove(0);
				debunkTopics.remove(index);
			}
			else {
				index ++;
			}
		}
		return found;
	}
	
	private static class Argument {
		String topic;
		int argument;
		Argument(String topic, int argument) {
			this.topic = topic;
			this.argument = argument;
		}
		boolean correspondsTo(Argument arg) {
			return this.topic.equals(arg.topic) && this.argument == arg.argument;
		}
	}
}
