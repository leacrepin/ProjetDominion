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
		// TODO Auto-generated method stub
		p.incrementMoney(2);
		List<String> choices = Arrays.asList("y", "n");
		String reponse = p.choose("Voulez-vous placer votre pioche dans la défausse (y/n) ?", choices, false);
		if(reponse=="y") {
			// CardList deck = p.getDeck();
			// TODO Que faut-il faire ? x)
		}
		
	}
}