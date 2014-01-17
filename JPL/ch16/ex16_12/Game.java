package ch16.ex16_12;

import java.net.URL;

public class Game {

    public static void main(String[] args) {

        String name;
        while ((name = getNextPlayer()) != null) {

            try {
                PlayerLoader loader = new PlayerLoader();
                Class<? extends Player> classOf = loader.loadClass(name)
                        .asSubclass(Player.class);
                Player player = classOf.newInstance();

                URL url = loader.findResource(name + ".book");

                Game game = new Game();
                player.play(game);
                player.use(url);
                game.reportScore(name);
            } catch (Exception e) {
                reportException(name, e);
            }
        }
    }

    private static final String[] PLAYER = { "BoldPlayer", "ShyPlayer" };

    private static int ID;

    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    private static String getNextPlayer() {

        if (ID >= PLAYER.length)
            return null;

        return PLAYER[ID++];
    }

    private void reportScore(String name) {
        System.out.println(name + ": " + score + " score");
    }

    private static void reportException(String name, Exception e) {
        System.err.println(name + ": " + e.toString());
    }

}
