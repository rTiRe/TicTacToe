package tire.tictactoe.game;

import tire.tictactoe.Main;
import tire.tictactoe.game.Check;

public class Fight {
    private Boolean player;
    private Table Table;
    private int size;
    private Check Check;

    public Fight(Table Table) {
        player = true;
        this.Table = Table;
        size = Table.getSize();
        Check = new Check(Table);
    }

    /**
     * Allows the player to make move, and also calls the check method.
     */
    public void move() {
        System.out.println(((player) ? "X" : "O") + " move:");
        Boolean[][] table = Table.getTable();
        int[] i = KeyListener.listenTwoInt();
        if(i[0] <= size && i[1] <= size && i[0] > 0 && i[1] > 0) {
            if (table[i[0] - 1][i[1] - 1] == null) {
                table[i[0] - 1][i[1] - 1] = player;
                player = !player;
                Table.setTable(table);
                for(int j = 0; j < size; j++) {

                    if( Check.check(0, j, 1, 0) |
                            Check.check(j, 0, 0, 1) |
                            Check.check(0, j, 1, 1) |
                            Check.check(size-1, j, -1, 1) ) return;
                }
                System.out.println("\n\n\n");
                Table.print(this);
            } else {
                System.out.println("Oops! It looks like this cell is already occupied!");
                move();
            }
        } else {
            System.out.println("You are out of the playing field!");
            move();
        }
    }
}
