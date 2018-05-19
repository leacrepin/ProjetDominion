package dominion.card.base;

import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix.
 * Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {
	public Thief() {
		super("Thief", 4);
	}

	@Override
	public void play(Player p) {
		CardList tresors = new CardList();
		CardList ecartees = new CardList();
		Card recup;
		Card drawn;
		String reponse, recuperer;
		
		
		for(Player pl : p.otherPlayers()) {
			// On demande au joueur pl de dévoiler 2 cartes de sa pioche.
			for(int i = 0; i < 2; i++) {
				drawn = pl.drawCard();
				if(drawn!=null) {
					System.out.println(drawn.getName()); // On affiche le nom de la carte dévoilée
					// Si c'est une carte trésor, elle est mise de coté, sinon elle est mise en défausse.
					if(drawn.getTypes().contains(CardType.Treasure)) {
						tresors.add(drawn);
					}else {
						pl.discardCard(drawn);
					}
				}
				// On demande au joueur p de choisir une carte à écarter si des cartes trésors ont été dévoilées. Les autres cartes sont remises en défausse.
				if(i==1) {
					if(tresors.size()>1) {
						reponse = p.chooseCard("Choisissez une carte trésor à écarter", tresors, true);
						if(!reponse.equals("")) {
							ecartees.add(tresors.remove(reponse));
						}
						for(Card c : tresors) {
							pl.discardCard(c);
						}
					}
					tresors.clear();
				}
			}
		}
		
		int taille = ecartees.size();
		//On parcours la liste des cartes écartées
		for(int i = 0; i < taille; i++) {
			//On demande au joueur p de choisir une carte à récupérer. S'il n'en choisit pas, on arrête la boucle
			recuperer = p.chooseCard("Entrez le nom de la carte que vous souhaitez récupérer, et laissez vide pour passer.", ecartees, true);
			if (recuperer.equals("")){
				break;
			} else {
				recup = ecartees.remove(recuperer);
				p.discardCard(recup);
			}
		}
		//On ecarte les cartes qui restent.
		for(Card c : ecartees) {
			p.getGame().throwCard(c);
		}
	}
}