package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	public Library() {
		super("Library", 5);
	}

	@Override
	public void play(Player p) {
		for(int i = 0; i < 7; i++) {
			Card drawn = p.drawCard();
			//if(drawn.getClass().getName().equals(arg0)) // TODO
			
		}
		// TODO Possibilité de mettre les cartes actions de côté / defausse
		
	}
}