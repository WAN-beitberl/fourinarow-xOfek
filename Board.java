import java.sql.SQLOutput;

public class Board {

    enum Square {
        RED,
        YELLOW,
        EMPTY
    }

    Square[][] board;
    public Board()
    {
        board = new Square[Main.ROWS][Main.COLS];

        for (int row = 0; row < Main.ROWS; row++)
        {
            for (int col = 0; col < Main.COLS; col++)
            {
                board[row][col] = Square.EMPTY;
            }
        }
    }

    public void PrintBoard()
    {
        for (int row = 0; row < Main.ROWS; row++)
        {
            for (int col = 0; col < Main.COLS; col++)
            {
                switch(board[row][col]) {
                    case EMPTY:
                        System.out.print("|   ");
                        break;
                    case RED:
                        System.out.print("| R ");
                        break;
                    case YELLOW:
                        System.out.print("| Y ");
                        break;
                }
            }
            System.out.println("|");
        }
    }

    public int PlaceToken(Square color, int col)
    {
        if (col < 0 || col >= Main.COLS)
        {
            System.out.println("Column out of bounds!");
            return -1;
        }

        int row;

        for (row = Main.ROWS - 1; row >= 0; row--)
        {
            if (board[row][col] == Square.EMPTY)
            {
                board[row][col] = color;
                return row;
            }
        }
        System.out.println("Column is full!");
        return -1;
    }
    public boolean CheckWin(Square color, int row, int col)
    {
        int count = 0;

        for (int i = 0; i < Main.ROWS; i++)
        {
            if (board[i][col] == color)
            {
                count++;
                if (count == Main.WIN_LEN)
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }
        count = 0;

        for (int i = 0; i < Main.COLS; i++)
        {
            if (board[row][i] == color)
            {
                count++;
                if (count == Main.WIN_LEN)
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }
        count = 0;

        int r = row;
        int c = col;

        while (r > 0 && c > 0)
        {
            r--;
            c--;
        }

        while (r < Main.ROWS && c < Main.COLS)
        {
            if (board[r][c] == color)
            {
                count++;
                if (count == Main.WIN_LEN)
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
            r++;
            c++;
        }
        count = 0;
        r = row;
        c = col;

        while (r > 0 && c < Main.COLS - 1)
        {
            r--;
            c++;
        }

        while (r < Main.ROWS && c > 0)
        {
            if (board[r][c] == color)
            {
                count++;
                if (count == Main.WIN_LEN)
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
            r++;
            c--;
        }

        return false;
    }
}
