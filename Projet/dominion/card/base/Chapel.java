package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	public Chapel() {
		super("Chapel", 2);
	}

	@Override
	public void play(Player p) {
		String reponse = new String();
		int nb = 4;
		
		boolean arretforce = true;
		while(arretforce && nb>0 && !p.cardsInHand().isEmpty()){
			reponse = p.chooseCard("Entrez le nom de la carte que vous voulez écarter (\"\" = passer)", p.cardsInHand(), true);
			if(!reponse.equals("")) {
				p.throwHand(reponse);
				nb--;
			}else{
				arretforce=false;
			}
		}
		
	}
}