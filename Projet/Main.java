import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Marco", "Polo"};
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		
		
		
		// Ajouter un bloc pour chaque carte royaume à utiliser (PACK DEBUTANT)
		CardList stack1 = new CardList();
		CardList stack2 = new CardList();
		CardList stack3 = new CardList();
		CardList stack4 = new CardList();
		CardList stack5 = new CardList();
		CardList stack6 = new CardList();
		CardList stack7 = new CardList();
		CardList stack8 = new CardList();
		CardList stack9 = new CardList();
		CardList stack10 = new CardList();
		for (int i = 0; i < 10; i++) {
			stack1.add(new Mine());
			stack2.add(new Militia());
			stack3.add(new Market());
			stack4.add(new Moat());
			stack5.add(new Woodcutter());
			stack6.add(new Smithy());
			stack7.add(new Cellar());
			stack8.add(new Workshop());
			stack9.add(new Remodel());
			stack10.add(new Village());
		}
		kingdomStacks.add(stack1);
		kingdomStacks.add(stack2);
		kingdomStacks.add(stack3);
		kingdomStacks.add(stack4);
		kingdomStacks.add(stack5);
		kingdomStacks.add(stack6);
		kingdomStacks.add(stack7);
		kingdomStacks.add(stack8);
		kingdomStacks.add(stack9);
		kingdomStacks.add(stack10);
		
		
		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}
}