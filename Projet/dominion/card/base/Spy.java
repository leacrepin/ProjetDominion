package dominion.card.base;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	public Spy() {
		super("Spy", 4);
	}

	@Override
	public void play(Player p) {
		Card drawn = p.drawCard();
		p.addToHand(drawn);
		p.incrementActions(1);
		List<Player> players = p.otherPlayers();
		players.add(0, p);
		
		//Joueurs qui ne se protègent pas
		List<Player> nonPP = new ArrayList<Player>();
		List<String> choices = Arrays.asList("y","n");
		CardList drawnList = new CardList();
		
		
		
		for(Player pl : players) {
			if(pl.cardsInHand().getCard("Moat")!=null){
				if(!((Moat)pl.cardsInHand().getCard("Moat")).protection(pl)){
					drawn = pl.drawCard();
					if(drawn!=null) {
						drawnList.add(drawn);
						nonPP.add(pl);
						System.out.println(drawn.toString());
					}
				}
			}else{
				drawn = pl.drawCard();
				if(drawn!=null) {
					drawnList.add(drawn);
					nonPP.add(pl);
					System.out.println(drawn.toString());
				}
			}
		}
		
		
		for(int i = 0; i < nonPP.size(); i++) {
			if(p.choose("'y' pour défausser la carte dévoilée, 'n' pour la replacer", choices, false)=="y") {
				nonPP.get(i).discardCard(drawnList.get(i));				
			} else {
				nonPP.get(i).addToDraw((drawnList.get(i)));
			}
		}
	}
}