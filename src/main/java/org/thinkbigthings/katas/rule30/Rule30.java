package org.thinkbigthings.katas.rule30;

import java.util.Arrays;

public class Rule30 {

    public boolean[] mapRow(boolean[] row) {
        boolean[] newRow = new boolean[row.length];
        Arrays.fill(newRow, false);
        for(int i=1; i < newRow.length - 1; i++) {
            newRow[i] = map(row, i);
        }
        return newRow;
    }

    // white == off == false
    // requires boolean array of length 3
    // int p is position, the center of what we can think of as a 3-element subarray
    private boolean map(boolean[] t, int p) {
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