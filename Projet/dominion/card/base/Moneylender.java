package dominion.card.base;
import java.util.Arrays;
import java.util.List;

import dominion.*;
import dominion.card.*;
import dominion.card.common.Copper;
import dominion.card.common.Silver;
import test.GameProxy;
import test.IOGame;
import test.PlayerProxy;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	public Moneylender() {
		super("Moneylender", 4);
	}

	@Override
	public void play(Player p) {
		if(p.cardsInHand().getCard("Copper")!=null) {
			p.throwHand("Copper");
			p.incrementMoney(3);
		}
	}
	
}