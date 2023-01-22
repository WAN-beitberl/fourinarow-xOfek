import java.util.Scanner;

public class Main {

    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static final int WIN_LEN = 4;
    public static void main(String[] args) {

        Connect4Game game = new Connect4Game();
        game.Play();
    }
}