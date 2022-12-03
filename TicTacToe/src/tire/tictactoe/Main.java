package tire.tictactoe;

import tire.tictactoe.game.Table;
import tire.tictactoe.game.KeyListener;
import tire.tictactoe.game.Fight;

public class Main {
    private static int size;
    private static Table Table;
    private static Fight Fight;

    {
        size = 0;
    }

    public static void main(String[] args) {
        start();
    }

    /**
     * Starts the game.
     */
    private static void start() {
        Table = new Table(setSize());
        Fight = new Fight(Table);
        Table.print(Fight);
    }

    /**
     * Sets the playing field width.
     * @return int. The width of the playing field.
     */
    private static int setSize() {
        System.out.println("Enter the field size (>=3 and <=15):");
        size = KeyListener.listenOneInt();
        if(size >= 3 && size <= 15) {
            return size;
        } else {
            return setSize();
        }
    }

    /**
     * Offers to play again or exit the game.
     */
    public static void replay() {
        System.out.println("\nPress Enter to play again.");
        System.out.println("Or type \"exit\" to exit the game.");
        if(KeyListener.listen().length() == 0) {
            start();
        } else {
            replay();
        }
    }

    /**
     * @return Fight. An instance of the Fight class.
     */
    public static Fight getFightClass() { return Fight; }
}
