package dominion.card.base;
import java.util.*;
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
		// TODO Auto-generated method stub
		Card thrown = p.cardsInHand().remove(p.chooseCard("Entrez le nom d'une carte que vous souhaitez écarter :", p.cardsInHand(), false));
		int cost = thrown.getCost() + 2;
		p.getGame().throwCard(thrown);
		CardList achats = p.getGame().availableSupplyCards();
		for(Card c : achats) {
			if(c.getCost()>cost) {
				achats.remove(c);
			}
		}
		p.gain(p.chooseCard("Entrez le nom d'une carte que vous souhaitez écarter :", achats, false)); //TODO canPass ???
		
	}
}