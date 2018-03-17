package HackerRank;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class QueensAttack {

    enum Direction {E, W, S, N, SE, NW, NE, SW}
    Map<Direction, Integer> numMoves = new HashMap<>();

    int getNumMoves(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Complete this function

        numMoves.put(Direction.E, c_q - 1);
        numMoves.put(Direction.W, n - c_q);

        numMoves.put(Direction.S, r_q - 1);
        numMoves.put(Direction.N, n - r_q);

        numMoves.put(Direction.SE, Math.min(r_q, c_q) - 1);
        numMoves.put(Direction.NW, n - Math.max(r_q, c_q));

        numMoves.put(Direction.NE, Math.min(n - r_q, c_q - 1));
        numMoves.put(Direction.SW, Math.min(r_q -1, n - c_q));
        System.out.println("no obstacles: " + numMoves);

        for(int[] obstacle: obstacles) {
            int[] delta = {obstacle[0] - r_q, obstacle[1] - c_q};
            updateNumMoves(delta);
        }
        System.out.println(numMoves);

        int sumMoves = 0;
        for(Direction dir: Direction.values()) {
            sumMoves += numMoves.get(dir);
        }
        return sumMoves;
    }

    void updateNumMoves(int[] delta) {
        //System.out.println("delta: " + Arrays.toString(delta));
        if (delta[0] == 0)
            updateIfLower((delta[1] < 0) ? Direction.E : Direction.W, Math.abs(delta[1]) - 1);
        else if (delta[1] == 0)
            updateIfLower((delta[0] < 0) ? Direction.S : Direction.N, Math.abs(delta[0]) - 1);
        else if(delta[0] == delta[1])
            updateIfLower((delta[0] < 0) ? Direction.SE : Direction.NW, Math.abs(delta[0]) - 1);
        else if(delta[0] + delta[1] == 0)
            updateIfLower((delta[0] < 0) ? Direction.SW : Direction.NE, Math.abs(delta[0]) - 1);
    }

    private void updateIfLower(Direction dir, int availMoves) {
        //System.out.println(dir + String.format(": %d moves", availMoves));
        numMoves.put(dir, Math.min(availMoves, numMoves.get(dir)));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        QueensAttack queensAttack = new QueensAttack();
        int result = queensAttack.getNumMoves(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}

