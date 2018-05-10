package dominion.card.base;
import java.util.*;
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
		// TODO vérifier si une carte copper est dans la main
		System.out.println("Voulez-vous écarter une carte 'copper' contre 3 pièces temporaires ?");
			// TODO récupérer l'avis de l'utilisateur
			Card copper = p.cardsInHand().remove("Copper");
	}
}