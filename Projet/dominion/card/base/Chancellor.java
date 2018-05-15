package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {
	public Chancellor() {
		super("Chancellor", 3);
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		List<String> choices = Arrays.asList("y", "n");
		if(p.choose("Voulez-vous placer votre pioche dans la défausse (y/n) ?", choices, false).equals("y")) {
			p.discardDraw();
		}
		
	}
}