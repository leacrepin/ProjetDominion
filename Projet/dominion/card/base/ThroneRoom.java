package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {
	public ThroneRoom() {
		super("Throne Room", 4);
	}

	@Override
	public void play(Player p) {
		CardList choices = p.getActionCards();
		String cardName = p.chooseCard("Entrez le nom de la carte que vous souhaitez jouer :", choices, false);
		Card carte = p.cardsInHand().remove(cardName);
		carte.play(p);
		carte.play(p);
		p.discardCard(carte);
	}
}