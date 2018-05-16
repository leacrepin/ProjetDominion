package dominion.card.base;
import java.util.Arrays;
import java.util.List;

import dominion.*;
import dominion.card.*;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {
	public Moat() {
		super("Moat", 2);
	}

	@Override
	public void play(Player p) {
		p.addToHand(p.drawCard());
		p.addToHand(p.drawCard());
		System.out.println("Le joueur "+p+" dévoile sa carte Moat");
	}
	
	public boolean protection(Player p){
		List<String> choices = Arrays.asList("y", "n");
		if(p.choose("Voulez-vous dévoiler votre carte (y/n) ?", choices, false).equals("y")) {
			play(p);
			return true;
		}else{
			return false;
		}
	}
}