package g42861.evaluation;

import g42861.rushhour.model.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Snail representant un escargot.
 *
 * @author G42861
 */
public class Snail {

    private String name;

    /**
     * Crée un escargot.
     *
     * @param name le nom de l'escargot
     */
    public Snail(String name) {
        this.setName(name);
    }

    /**
     * Accesseur pour l'attribut nom
     *
     * @return le nom de l'escargot
     */
    public String getName() {
        return name;
    }

    /**
     * Mutateur de l'attribut nom
     *
     * @param name le nouveau nom de l'escargot
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Determine les n prochain movement de l'escargot
     *
     * @param n le nombre de mouvement à determiner
     * @return une liste de n prochain mouvement de l'escargot
     */
    public List<Direction> getMoves(int n) {
        List<Direction> listMoves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int nbAuHasard = (int) (Math.random() * 4) + 1;

            switch (nbAuHasard) {
                case 1:
                    listMoves.add(Direction.UP);
                    break;
                case 2:
                    listMoves.add(Direction.DOWN);
                    break;
                case 3:
                    listMoves.add(Direction.LEFT);
                    break;
                case 4:
                    listMoves.add(Direction.RIGHT);
            }

        }
        return listMoves;
    }
}
