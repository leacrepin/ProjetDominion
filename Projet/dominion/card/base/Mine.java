package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	public Mine() {
		super("Mine", 5);
	}

	@Override
	public void play(Player p) {
		if(!p.getTreasureCards().isEmpty()) {
			// écarter une carte trésor au choix, puis, si succès :
			// TODO prendre une carte au trésor où {coutNouvelleCarte est entre coutAncienneCarte & coutAncienneCarte+3}
			// TODO l'ajouter à la main
			// Player.demanderChoix() renvoie une chaine potentiellement érronnée
			String[] cartesTresor = {"Copper", "Silver", "Gold"};
			String cartesTresorPossedees = new String("Veuillez supprimer une des cartes suivantes :");
			String choix = new String();
			boolean[] nums = {false, false, false};
			for(Card c : p.cardsInHand()) {
				for(int i = 0; i < cartesTresor.length; i++) {
					if(c.getName()==cartesTresor[i]) {
						nums[i] = true;
					}
				}
			}
			for(int i = 0; i < nums.length; i++) {
				if(nums[i]) {
					cartesTresorPossedees += cartesTresor[i];
				}
			}
			while((choix!=cartesTresor[0]||!nums[0])&&(choix!=cartesTresor[1]||!nums[1])&&(choix!=cartesTresor[2]||!nums[2])) {
				System.out.println(cartesTresorPossedees);
				choix = Player.demanderChoix();
			}// TODO tester !!!
			Card jetee = p.cardsInHand().remove(choix);
			int costNew = jetee.getCost() + 3;
			p.getGame().throwCard(jetee);
			
			
		}
	}
}