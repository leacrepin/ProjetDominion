package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {
	public Witch() {
		super("Witch", 5);
	}

	@Override
	public void play(Player p) {
		p.addToHand(p.drawCard());
		p.addToHand(p.drawCard());
		for(Player pl : p.otherPlayers()) {
			if(pl.cardsInHand().getCard("Moat")!=null){
				if(!((Moat) pl.cardsInHand().getCard("Moat")).protection(pl)){
					pl.gain("Curse");
				}
			}else{
				pl.gain("Curse");
			}
		}
	}
}