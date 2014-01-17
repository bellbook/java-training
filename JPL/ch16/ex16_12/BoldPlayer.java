package ch16.ex16_12;

public class BoldPlayer extends Player {

    @Override
    public void play(Game game) {
        game.setScore(100);
    }

}
