package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. 
 * Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; 
 * ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	public Mine() {
		super("Mine", 5);
	}

	@Override
	public void play(Player p) {
		if(!p.getTreasureCards().isEmpty()) {
			CardList tresors = p.getTreasureCards();
			String reponse = p.chooseCard("Entrez le nom d'une carte trésor que vous souhaitez écarter :", tresors, false);
			Card thrown = p.throwHand(reponse);
			int cost = thrown.getCost()+3;
			CardList supply = p.getGame().availableSupplyCards();
			CardList aRecevoir = new CardList();
			for(Card c : supply) {
				if(c.getTypes().contains(CardType.Treasure) && c.getCost()<=cost) {
					aRecevoir.add(c);
				}
			}
			reponse=p.chooseCard("Entrez le nom de la carte trésor que vous souhaitez recevoir coûtant jusqu'à "+cost+" :", aRecevoir, false);
			p.gainHand(reponse);
			
		}
	}
}