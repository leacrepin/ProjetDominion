package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	public Library() {
		super("Library", 5);
	}

	@Override
	public void play(Player p) {
		CardList misesDeCote = new CardList();
		List<String> choices = Arrays.asList("y","n");
		List<CardType> listeDesTypes;
		Card drawn = p.drawCard();
		while(p.cardsInHand().size()<7 && drawn!=null) {
				listeDesTypes = drawn.getTypes();
				if(listeDesTypes.contains(CardType.Action)) {
					if(p.choose("Voulez-vous mettre cette carte Action de côté ?(y/n)", choices, true)=="y") {
						misesDeCote.add(drawn);
					} else {
						p.addToHand(drawn);
					}
				}
			drawn = p.drawCard();
		}
		for(Card c : misesDeCote) {
			p.discardCard(c);
		}
		
	}
}