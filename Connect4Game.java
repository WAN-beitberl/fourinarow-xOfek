import java.util.Scanner;

public class Connect4Game {
    public static Scanner sc = new Scanner(System.in);

    Board board;
    Player redPlayer;
    Player yellowPlayer;

    public Connect4Game()
    {
        board = new Board();
        redPlayer = new Player(Player.Color.RED);
        yellowPlayer = new Player(Player.Color.YELLOW);
    }

    public void Play()
    {
        Board.Square sqr;
        System.out.println("Which player shall start? (R or Y)");
        char c = sc.next().charAt(0);

        if (c == 'R')
        {
            sqr = Board.Square.RED;
        }
        else
        {
            sqr = Board.Square.YELLOW;
        }

        int turns;
        int maxTurns = Main.ROWS * Main.COLS;
        int col = 0;
        int row;

        for (turns = 0; turns < maxTurns; turns++)
        {
            row = -1;
            board.PrintBoard();

            while (row == -1)
            {
                System.out.println(sqr + " player, enter a column:");
                col = sc.nextInt();
                col--;

                row = board.PlaceToken(sqr, col);
            }

            if (board.CheckWin(sqr, row, col))
            {
                if (sqr == Board.Square.RED)
                {
                    System.out.println("Red player has won! GGs");
                    redPlayer.wins++;
                }
                else
                {
                    System.out.println("Yellow player has won! GGs");
                    yellowPlayer.wins++;
                }
                break;
            }
            if (sqr == Board.Square.RED)
            {
                sqr = Board.Square.YELLOW;
            }
            else
            {
                sqr = Board.Square.RED;
            }
        }

        board.PrintBoard();

        if (turns == maxTurns)
        {
            System.out.println("Draw!");
        }
    }
}
