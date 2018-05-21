package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	public Remodel() {
		super("Remodel", 4);
	}

	@Override
	public void play(Player p) {
		if(!p.cardsInHand().isEmpty()){
			String reponse = p.chooseCard("Entrez le nom d'une carte que vous souhaitez écarter :", p.cardsInHand(), false);
			Card thrown = p.throwHand(reponse);
			int cost = thrown.getCost() + 2;
			CardList supply = new CardList(p.getGame().availableSupplyCards());
			CardList achats = new CardList();
			for(Card c : supply) {
				if(c.getCost()<=cost) {
					achats.add(c);
				}
			}
			p.gain(p.chooseCard("Entrez le nom d'une carte que vous souhaitez recevoir coûtant jusqu'à "+cost+" :", achats, false));
		}
	}
}