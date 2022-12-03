package tire.tictactoe.game;

import tire.tictactoe.game.Fight;

public class Table {

    private Boolean[][] table;
    private int size;
    private char symbol;

    public Table(int size) {
        this.size = size;
        table = new Boolean[size][size];
        symbol = 'x';
    }

    /**
     * Displays the playing field on the screen.
     */
    public void print() {
        System.out.print("\r");
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                if(table[i][j] != null) {
                    if(table[i][j]) symbol = 'x';
                    else symbol = 'o';
                    System.out.print("  " + symbol + "  ");
                } else {
                    System.out.print("     ");
                }
                if(j+1 != table[i].length) { System.out.print("|"); }
            }
            System.out.println();
            if(i+1 != table.length) {
                for(int j = 0; j < table[i].length; j++) {
                    System.out.print("-----");
                    if(j+1 != table[i].length) { System.out.print("-"); }
                }
            }
            System.out.println();
        }
        System.out.flush();
    }
    /**
     * Displays the playing field on the screen, and then asks to make a move.
     * @param Fight – an instance of the Fight class
     */
    public void print(Fight Fight) {
        print();
        Fight.move();
    }

    /**
     * @return Boolean[][]. The playing field as a Boolean two-dimensional array.
     */
    public Boolean[][] getTable() { return table; }

    /**
     * Updates the playing field.
     * @param table – Boolean[][] two-dimensional array
     */
    public void setTable(Boolean[][] table) { this.table = table; }

    /**
     * @return int. The width of the playing field.
     */
    public int getSize() { return size; }
}
