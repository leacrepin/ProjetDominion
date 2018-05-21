package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	public Workshop() {
		super("Workshop", 3);
	}

	@Override
	public void play(Player p) {
		CardList supply = p.getGame().availableSupplyCards();
		CardList achats = new CardList();
		for(Card carte : supply) {
			if(carte.getCost()<=4) {
				achats.add(carte);
			}
		}
		p.gain(p.chooseCard("Entrez le nom d'une carte que vous voulez recevoir coûtant jusqu'à 4 :", achats, false));	
	}
}