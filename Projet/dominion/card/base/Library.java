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
		boolean confirmation;
		for(int i = 0; i < 7; i++) {
			Card drawn = p.drawCard();
			List<CardType> listeDesTypes = drawn.getTypes();
			if(listeDesTypes.contains(CardType.Action)) {
				System.out.println("Voulez-vous mettre cette carte Action de côté ?");
				confirmation = p.confirmer();
				if(confirmation) {
					misesDeCote.add(drawn);
					i--;
				}
			}
		}
		for(Card c : misesDeCote) {
			p.discardCard(c);
		}
		
	}
}