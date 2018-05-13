package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {
	public Thief() {
		super("Thief", 4);
	}

	@Override
	public void play(Player p) {
		for(Player pl : p.otherPlayers()) {
			CardList devoilees = new CardList();
			devoilees.add(pl.drawCard());
			devoilees.add(pl.drawCard());
			// TODO récupérer ou écarter une carte trésor si 'p' le souhaite
			// TODO défausser ce qui reste
		}
		
	}
}