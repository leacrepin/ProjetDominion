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
		String reponse="";
		
		boolean arretforce = true;
		while(arretforce && !p.cardsInHand().isEmpty()){
			reponse = p.chooseCard("Entrez le nom des cartes que vous voulez défausser (\"\" = passer)", p.cardsInHand(), true);
			if(!reponse.equals("")) {
				p.discardHand(reponse);
				pioche++;
			}else{
				arretforce=false;
			}
		}
		
		for(int i = 0; i < pioche; i++) {
			p.addToHand(p.drawCard());
		}
		
	}
}