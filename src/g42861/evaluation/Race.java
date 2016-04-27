package g42861.evaluation;

import g42861.rushhour.model.Direction;
import java.util.ArrayList;
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

    /**
     * Determine le vainqueur d'une course.
     *
     * @param n le nombre de mouvement que chaque escargot doit faire
     * @return l'escargot qui a le plus grand score
     */
    public Snail run(int n) {
        Snail vainqueur = null;
        int score;
        int scoreMax = Integer.MIN_VALUE;

        for (Snail snail : snails) {
            score = distance(snail.getMoves(n));
            if (score > scoreMax) {
                scoreMax = score;
                vainqueur = snail;
            }
        }

        return vainqueur;
    }

    /**
     * Instancie une course, affiche le nom des participant et le vainqueur en
     * fin de course.
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo"));
        snails.add(new Snail("Taco-Man"));
        snails.add(new Snail("Smoove move"));
        snails.add(new Snail("Guy la gagne"));

        Race course = null;
        try {
            course = new Race(snails);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("la course commence avec : ");
        for (Snail snail : course.snails) {
            System.out.print(snail.getName() + ", ");
        }
        int nbDeplacement = (int) (Math.random() * 20) + 1;
        System.out.println("\nVainqueur : "
                + course.run(nbDeplacement).getName());
    }
}
