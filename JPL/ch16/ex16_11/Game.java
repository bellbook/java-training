package ch16.ex16_11;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Game {

    public static void main(String[] args) {

        String name;
        while ((name = getNextPlayer()) != null) {

            try {
                File jar = new File("resources/ch16/player.jar");
                URL url = jar.getCanonicalFile().toURI().toURL();

                URLClassLoader loader = new URLClassLoader(new URL[] { url });

                Class<? extends Player> classOf = loader.loadClass(name)
                        .asSubclass(Player.class);
                Player player = classOf.newInstance();

                Game game = new Game();
                player.play(game);
                game.reportScore(name);
            } catch (Exception e) {
                reportException(name, e);
            }
        }
    }

    private static final String[] PLAYER = { "DumbPlayer", "SneakyPlayer" };

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
        System.err.println(name + ": " + e);
    }

}
