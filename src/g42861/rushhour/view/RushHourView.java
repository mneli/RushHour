package g42861.rushhour.view;

import g42861.rushhour.model.RushHourException;
import g42861.rushhour.model.RushHourGame;

/**
 *
 * @author G42861
 * @group B231
 */
public class RushHourView {

    private RushHourGame game;

    public RushHourView(RushHourGame game) {
        this.game = game;
    }

    public void play() throws RushHourException {

        while (!game.isOver()) {
            //demander id
            //demander direction
            //deplacer car
            //afficher plateau
        }

    }
}
