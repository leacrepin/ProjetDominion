package dominion.card.base;
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
		// TODO protection contre attaque
		p.addToHand(p.drawCard());//piocher pour mettre dans la main
		p.addToHand(p.drawCard());
	}
}