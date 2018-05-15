package dominion.card.base;
import java.util.Arrays;
import java.util.List;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	public Spy() {
		super("Spy", 4);
	}

	@Override
	public void play(Player p) {
		p.drawCard();
		p.incrementActions(1);
		String[]choix = new String[]{"y","n"};
		List<String> choices = Arrays.asList(choix);
		CardList devoilees = new CardList();
		Card devoilee;
		List<Player> players = p.otherPlayers();
		players.add(p);
		for(int i = 0; i<players.size();i++) {
			devoilee = players.get(i).drawCard();
			players.get(i).cardsInHand().remove(devoilee);
			devoilees.add(devoilee);
		}
		
		if(p.choose("'y' pour défausser ces cartes, 'n' pour les replacer.", choices, false)=="y") {
			for(int i = 0; i<players.size();i++) {
				players.get(i).addToDraw(devoilees.get(i));
			}
		} else {
			for(int i = 0; i<players.size();i++) {
				players.get(i).getGame().throwCard(devoilees.get(i));
			}
		}
		
	}
}