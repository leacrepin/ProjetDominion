package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	public Adventurer() {
		super("Adventurer", 6);
	}

	@Override
	public void play(Player p) {
		Card drawn = p.drawCard();
		System.out.println(drawn.getName());
		int i = 0;
		
		while(drawn!=null && i < 2) {
			List<CardType> listeDesTypes = drawn.getTypes();
			if(listeDesTypes.contains(CardType.Treasure)) {
				i++;
			} else {
				p.discardCard(drawn);
			}
			drawn = p.drawCard();
			System.out.println(drawn.getName());
		}
	}
}