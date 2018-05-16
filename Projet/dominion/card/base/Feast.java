package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {
	public Feast() {
		super("Feast", 4);
	}

	@Override
	public void play(Player p) {
		String reponse = p.chooseCard("Entrez le nom de la carte que vous voulez écarter :",p.cardsInHand(),false);
		p.throwHand(reponse);
		
		CardList supply = new CardList(p.getGame().availableSupplyCards());
		CardList aPiocher = new CardList();
		for(Card c : supply) {
			if(c.getCost()<=5) {
				aPiocher.add(c);
			}
		}
		reponse=p.chooseCard("Entrez le nom de la carte coûtant jusqu'à 5 Pièces, que vous voulez recevoir :",aPiocher,false);
		p.gain(reponse);
	}
}	