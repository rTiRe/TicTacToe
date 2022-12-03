package tire.tictactoe.game;

import tire.tictactoe.Main;

public class Check {
    private int winCombination;
    private Table Table;

    public Check(Table Table) {
        winCombination = 3;
        this.Table = Table;
    }

    /**
     * Iterates through an array looking for a combination of characters.
     * @param x – X start point
     * @param y – Y start point
     * @param xCoef – X offset factor (+)
     * @param yCoef – Y offset factor (+)
     * @return Boolean. If there are some numbers of consecutive characters - true. Otherwise - false.
     */
    public Boolean check(int x, int y, int xCoef, int yCoef) {
        Boolean[][] table = Table.getTable();
        Boolean previous = null;
        int combo = 1;
        int size = Table.getSize();

        // Перебираем каждый элемент массива, сравнивая с предыдущим
        // Это то, что ищет комбинацию символов.
        for(int i = 0; (i < size) && (x < size) && (y < size) && (x >= 0) && (y >= 0); i++) {
            if(previous == table[y][x] && table[y][x] != null) {
                combo++;
                if(combo >= winCombination) {
                    System.out.println("\n\n\n");
                    Table.setTable(table);
                    Table.print();
                    for(int j = 0; j < 5; j++) {
                        System.out.println(((previous) ? "x" : "o") + " WIN!");
                    }
                    Main.replay();
                    return true;
                }
            }
            else combo = 1;
            previous = table[y][x];

            x += (xCoef);
            y += (yCoef);
        }

        return false;
    }
}
