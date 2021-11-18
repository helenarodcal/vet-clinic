package serenitylabs.tutorials.vetclinic.playingball.model;

public class DontKnowThatGameException extends RuntimeException {
    public DontKnowThatGameException(){
        System.out.println("Don't know how to play that game");
    }
}
