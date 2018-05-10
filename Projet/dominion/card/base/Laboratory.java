package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Laboratoire (Laboratory)
 * 
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends ActionCard {
	public Laboratory() {
		super("Laboratory", 5);
	}

	@Override
	public void play(Player p) {
		p.drawCard();
		p.drawCard();
		p.incrementActions(1);
		
	}
}