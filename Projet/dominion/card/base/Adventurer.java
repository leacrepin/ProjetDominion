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
		int i = 0;
		while(i < 2) {
			Card drawn = p.drawCard();
			if(drawn != null){
				List<CardType> listeDesTypes = drawn.getTypes();
				if(listeDesTypes.contains(CardType.Treasure)) {
					i++;
					p.addToHand(drawn);
				} else {
					p.discardCard(drawn);
				}
			}else{
				i=2;
			}
		}
	}
}