package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bûcheron (Woodcutter)
 * 
 * +1 Achat.
 * +2 Pièces.
 */
public class Woodcutter extends ActionCard {
	public Woodcutter() {
		super("Woodcutter", 3);
	}

	@Override
	public void play(Player p) {
		p.incrementBuys(1);
		p.incrementMoney(2);
	}
}