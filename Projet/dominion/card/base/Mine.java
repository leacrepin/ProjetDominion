package dominion.card.base;
import java.util.*;
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
			// TODO écarter une carte trésor au choix, puis, si succès :
			// TODO prendre une carte au trésor où {coutNouvelleCarte est entre coutAncienneCarte & coutAncienneCarte+3}
			// TODO l'ajouter à la main
		}
	}
}