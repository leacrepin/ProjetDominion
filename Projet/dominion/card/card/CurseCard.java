package dominion.card;
import java.util.*;
import dominion.*;
import dominion.card.common.Curse;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {
	public CurseCard(String name, int cost) {
		super(name, cost);
	}
}