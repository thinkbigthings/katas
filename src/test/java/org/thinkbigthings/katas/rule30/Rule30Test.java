package org.thinkbigthings.katas.rule30;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Rule30Test {

    private final Rule30 rule = new Rule30();
    private boolean[] initial;

    private boolean[][] expected;

    @Before
    public void setup() throws Exception {
        initial = new boolean[15];
        Arrays.fill(initial, false);
        initial[7] = true;

        int[][] expectedAsInts = new int[][] {
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,1,0,1,1,1,1,0,0,0,0},
                {0,0,0,1,1,0,0,1,0,0,0,1,0,0,0}
        };

        expected = new boolean[5][15];
        for(int r=0; r < expectedAsInts.length; r++) {
            for(int c=0; c < expectedAsInts[r].length; c++){
                expected[r][c] = (expectedAsInts[r][c] == 1);
            }
        }
    }

//    public static void print(boolean[] row) {
//        for(boolean r : row) {
//            System.out.print(r ? "X" : "_");
//        }
//        System.out.println();
//    }

    @Test
    public void testRule() throws Exception {

        boolean[] row = initial;

        for(int i=0; i < 5; i++) {
//            print(row);
            Assert.assertTrue(Arrays.equals(expected[i], row));
            row = rule.mapRow(row);
        }

    }

}
