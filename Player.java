public class Player {

    enum Color {
        RED,
        YELLOW
    }

    Color color;
    int wins;
    public Player(Color color)
    {
        this.color = color;
        wins = 0;
    }


}
