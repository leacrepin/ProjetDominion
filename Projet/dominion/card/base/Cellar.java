package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	public Cellar() {
		super("Cellar", 2);
	}

	@Override
	public void play(Player p) {
		// TODO Auto-generated method stub
		p.incrementActions(1);
		
	}
}