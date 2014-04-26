package org.thinkbigthings.katas.rule30;

import java.util.Arrays;

public class Rule30 {

    public static void main(String[] args) {
        boolean[] row = new boolean[15];
        Arrays.fill(row, false);
        row[8] = true;
        for(int i=0; i < 15; i++) {
            print(row);
            row = mapRow(row);
        }
    }

    public static void print(boolean[] row) {
        for(boolean r : row) {
            System.out.print(r ? "X" : "_");
        }
        System.out.println();
    }

    public static boolean[] mapRow(boolean[] row) {
        boolean[] newRow = new boolean[row.length];
        Arrays.fill(newRow, false);
        for(int i=1; i < newRow.length - 1; i++) {
            newRow[i] = map(row, i);
        }
        return newRow;
    }

    // white == off == false
    // requires boolean of length 3
    // int p is position, the center of what we can think of as a 3-element subarray
    public static boolean map(boolean[] t, int p) {
        if( ! t[p-1] && ! t[p] && ! t[p+1]) {
            return false;
        }
        if( ! t[p-1] && ! t[p] &&   t[p+1]) {
            return true;
        }
        if( ! t[p-1] &&   t[p] && ! t[p+1]) {
            return true;
        }
        if( ! t[p-1] &&   t[p] &&   t[p+1]) {
            return true;
        }
        if(   t[p-1] && ! t[p] && ! t[p+1]) {
            return true;
        }
        if(   t[p-1] && ! t[p] &&   t[p+1]) {
            return false;
        }
        if(   t[p-1] &&   t[p] && ! t[p+1]) {
            return false;
        }
        if(   t[p-1] &&   t[p] &&   t[p+1]) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}