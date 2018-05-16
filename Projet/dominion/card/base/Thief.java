package dominion.card.base;
import java.util.Arrays;
import java.util.List;

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
		CardList tresors = new CardList();
		CardList ecartees = new CardList();
		List<String> choix = Arrays.asList("y", "n");
		Card drawn;
		String reponse = new String();
		
		
		for(Player pl : p.otherPlayers()) {
			for(int i = 0; i < 2; i++) {
				drawn = pl.drawCard();
				if(drawn!=null) {
					if(drawn.getTypes().contains(CardType.Treasure)) {
						tresors.add(drawn);
					}
				}
			}
			if(tresors.size()==2) {
				reponse = p.chooseCard("Choisissez une carte trésor à écarter", tresors, true);
				if(!reponse.isEmpty()) {
					ecartees.add(pl.removeFromHand(reponse));	
				}
			}
			tresors.clear();
		}
		
		for(Card carte : ecartees) {
			//TODO ce p.choose marche pas...
			if(p.choose("Récupérer "+carte.getName()+" ?(y/n)", choix, true).equals("y")) {
				p.discardCard(carte);
			}else {
				p.getGame().throwCard(carte);
			}
		}
	}
}