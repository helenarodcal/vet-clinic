package serenitylabs.tutorials.vetclinic.playingball.model;

public interface Player {
      default void play() {
    }

     static Player gameCalled(Game game) {
        switch (game) {
            case Cricket:
                return new PlayCricket();
            case Football:
                return new PlayFootball();
            case Handball:
                return new PlayHandball();
            case Hockey:
                return new PlayHockey();
            case Tennis:
                return new PlayTennis();
            default:
                throw new DontKnowThatGameException();
        }

    }
}
