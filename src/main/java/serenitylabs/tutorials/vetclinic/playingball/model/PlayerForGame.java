package serenitylabs.tutorials.vetclinic.playingball.model;

//FACTORY CLASS
public class PlayerForGame {
    public static Player called(Game game) {
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
