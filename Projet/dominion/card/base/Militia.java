package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	public Militia() {
		super("Militia", 4);
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		for(Player op : p.otherPlayers()) {
			while(op.cardsInHand().size()>3) {
				op.discardCard(op.cardsInHand().remove(op.chooseCard("Entrez le nom de la carte que vous voulez défausser :", op.cardsInHand(), false)));
			}
		}		
	}
}