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
		p.gain("Silver");
		p.discardHand("Silver");
		List<Player> players = p.otherPlayers();
		CardList choices = new CardList();
		for(Player pl : players) {
			if(!pl.getVictoryCards().isEmpty()) {
				// TODO Echec
				choices.addAll(pl.getVictoryCards());
				System.out.println(pl.chooseCard("Entrez le nom de la carte que vous devez dévoiler", choices, false));
				choices.clear();
			} else {
				System.out.println(pl.cardsInHand().toString());
			}
		}
		
	}
}