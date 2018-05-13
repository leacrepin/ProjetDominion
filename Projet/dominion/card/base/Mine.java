package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	public Mine() {
		super("Mine", 5);
	}

	@Override
	public void play(Player p) {
		if(!p.getTreasureCards().isEmpty()) {
			CardList tresors = p.getTreasureCards();
			Card thrown = p.cardsInHand().remove(p.chooseCard("Entrez le nom d'une carte que vous souhaitez écarter :", tresors, false));
			int cost = thrown.getCost()+3;
			p.getGame().throwCard(thrown);
			CardList supply = p.getGame().availableSupplyCards();
			CardList aRecevoir = new CardList();
			for(Card c : supply) {
				if(c.getTypes().contains(CardType.Treasure) && c.getCost()<=cost) {
					aRecevoir.add(c);
				}
			}
			p.gain(p.chooseCard("Entrez le nom de la carte que vous souhaitez recevoir :", aRecevoir, false)); //TODO canPass ???
			
		}
	}
}