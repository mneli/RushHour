package g42861.evaluation;

import g42861.rushhour.model.Direction;
import java.util.List;

/**
 * Classe Race permettant de faire la course
 *
 * @author G42861
 */
public class Race {

    private Snail[] snails;

    /**
     * Crée une course
     *
     * @param snails une liste d'escargot
     * @throws RaceException si le nombre d'escargot participant est inférieure
     * à deux
     */
    public Race(List<Snail> snails) throws RaceException {
        if (snails.size() < 2) {
            throw new RaceException("Erreur : "
                    + "au moins 2 escargots doivent participer");
        }
        this.snails = new Snail[snails.size()];
        for (int i = 0; i < snails.size(); i++) {
            this.snails[i] = snails.get(i);
        }
    }

    /**
     * Détermine la distance parcourue par en fonctions d'une liste de mouvement
     * d'un escargot
     *
     * @param directions la liste des mouvement
     * @return la distance parcourue
     */
    public int distance(List<Direction> directions) {
        int distanceParcourue = 0;
        for (Direction direction : directions) {
            switch (direction) {
                case UP:
                    distanceParcourue++;
                    break;
                case DOWN:
                    distanceParcourue--;
                default:
            }
        }
        return distanceParcourue;
    }
}
