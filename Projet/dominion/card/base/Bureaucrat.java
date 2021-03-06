package dominion.card.base;

import java.util.List;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	public Bureaucrat() {
		super("Bureaucrat",4);
	}

	@Override
	public void play(Player p) {
		p.gainHand("Silver");
		p.handToDeck("Silver");
		String choix = new String();
		List<Player> players = p.otherPlayers();
		CardList choices = new CardList();
		for(Player pl : players) {
			if(!pl.getVictoryCards().isEmpty()) {
				choices.addAll(pl.getVictoryCards());
				choix = pl.chooseCard("Entrez le nom de la carte Victoire que vous devez dévoiler", choices, false);
				System.out.println(choix);
				pl.handToDeck(choix);
				choices.clear();
			}
		}
		
	}
}