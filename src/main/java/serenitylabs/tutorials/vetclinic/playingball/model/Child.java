package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Player.*;

public class Child {

    public void goPlay(Game game) {
        Player gameToPlay = gameCalled(game);
        gameToPlay.play();

    }


}
