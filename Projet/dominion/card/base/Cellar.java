package dominion.card.base;
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
		int pioche = 0;
		p.incrementActions(1);
		String reponse = new String();
		
		do{
			reponse = p.chooseCard("Entrez le nom des cartes que vous voulez défausser (\"\" = passer)", p.cardsInHand(), true);
			if(reponse!="") {
				p.discardCard(p.cardsInHand().remove(reponse));
				pioche++;
			}
		}while(reponse!="" && !p.cardsInHand().isEmpty());
		
		for(int i = 0; i < pioche; i++) {
			p.drawCard();
		}
		
	}
}