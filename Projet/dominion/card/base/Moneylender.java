package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	public Moneylender() {
		super("Money Lender", 4);
	}

	@Override
	public void play(Player p) {
		if(p.cardsInHand().getCard("copper")!=null) {
			System.out.println("Voulez-vous écarter une carte 'copper' contre 3 pièces temporaires ?");
			if(p.confirmer()) {
				p.getGame().throwCard(p.cardsInHand().remove("Copper"));
				p.incrementMoney(3);
			}
		}
	}
}