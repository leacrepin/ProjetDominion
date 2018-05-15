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
		String reponse = new String();
		Card removed;
		p.gain("Copper");
		p.addToDraw(p.cardsInHand().remove("Copper"));
		List<Player> players = p.otherPlayers();
		for(Player pl : players) {
			if(!pl.getVictoryCards().isEmpty()) {
				reponse = pl.chooseCard("Entrez le nom d'une carte que vous souhaitez dévoiler :", pl.getVictoryCards(), false);
				System.out.println(reponse);
				removed = pl.cardsInHand().remove(reponse);
				pl.addToDraw(removed);
			}
		}
		
	}
}