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
		//TODO A refaire provoque une [ERREUR]
		String reponse = p.chooseCard("Entrez le nom de la carte que vous voulez écarter :",p.cardsInHand(),false);
		p.throwHand(reponse);
		
		CardList aPiocher = p.getGame().availableSupplyCards();
		for(Card c : aPiocher) {
			if(c.getCost()>5) {
				aPiocher.remove(c);
			}
		}
		reponse=p.chooseCard(
				"Entrez le nom de la carte coûtant jusqu'à 5 Pièces, que vous voulez recevoir :",
				aPiocher,
				false
			);
		p.gain(reponse);
	}
}	