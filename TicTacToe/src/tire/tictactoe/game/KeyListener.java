package tire.tictactoe.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyListener {

    private static BufferedReader reader;
    private static int[] coords;
    private static String[] s;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        coords = new int[2];
        s = new String[2];
    }

    /**
     * Reads a line.
     * @return String.
     */
    public static String listen() {
        try {
            String c = reader.readLine().trim();
            exit(c);
            return c;
        } catch(Exception e) {
            return listen();
        }
    }

    /**
     * Reads one number.
     * @return int. If not a number was entered - returns itself.
     */
    public static int listenOneInt() {
        try {
            String c = listen();
            return Integer.parseInt(c);
        } catch(Exception e) {
            return listenOneInt();
        }
    }

    /**
     * Reads two numbers separated by a space.
     * @return int[2]. If less, more, or not a number was entered - returns itself.
     */
    public static int[] listenTwoInt() {
        try {
            String c = listen();
            s = c.split(" ", 2);
            for(int i = 0; i < s.length; i++) {
                coords[i] = Integer.parseInt(s[i]);
            }
            return coords;
        } catch(Exception e) {
            return listenTwoInt();
        }
    }

    /**
     * Exits the programm with code 130 if the recived string mathces "exit".
     * @param s – string to check
     */
    private static void exit(String s) {
        if(s.equalsIgnoreCase("exit")) System.exit(130);
    }
}
