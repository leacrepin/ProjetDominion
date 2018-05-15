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
		List<Player> players = p.otherPlayers();
		Card devoilee;
		int ecartee;
		String[]choix = new String[]{"y","n"};
		List<String> choices = Arrays.asList(choix);
		//CardList devoilees = new CardList();
		for(int i = 0; i<players.size();i++) {
			ecartee = 0;
			devoilee = players.get(i).drawCard();
			players.get(i).cardsInHand().remove(devoilee);
			//devoilees.add(devoilee);
			if(devoilee.getTypes().contains(CardType.Treasure)) {
				if(p.choose("Voulez-vous écarter cette carte trésor ?(y/n)", choices, true)=="y") {
					p.getGame().throwCard(devoilee);
					ecartee++;
				} else {
					p.discardCard(devoilee);
				}
			}
			devoilee = players.get(i).drawCard();
			players.get(i).cardsInHand().remove(devoilee);
			//devoilees.add(devoilee);
			if(devoilee.getTypes().contains(CardType.Treasure)&&ecartee==0) {
				if(p.choose("Voulez-vous écarter cette carte trésor ?(y/n)", choices, true)=="y") {
					p.getGame().throwCard(devoilee);
					ecartee++;
				} else {
					p.discardCard(devoilee);
				}
			}
			
			
			
			
			// TODO récupérer ou écarter une carte trésor si 'p' le souhaite
			// TODO défausser ce qui reste
		}
		
	}
}