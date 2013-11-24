package org.thinkbigthings.katas.streams;

import org.thinkbigthings.katas.streams.MergedIterator;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MergedIteratorTest {

    private final List<Integer> expectedMerge;
    private final MergedIterator<Integer> mergedIterator;

    public MergedIteratorTest(List<Integer> list1, List<Integer> list2, List<Integer> expected) {
        expectedMerge = expected;
        mergedIterator = new MergedIterator<>(list1.iterator(), list2.iterator());
    }

    @Test
    public void testIterator() throws Exception {
        List<Integer> merged = streamIntoList(mergedIterator);
        assertEquals(expectedMerge, merged);
    }

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new ArrayList<>(), new ArrayList<>(), new ArrayList<>()},
            {Arrays.asList(1, 2, 3, 4, 5, 6), new ArrayList<>(), Arrays.asList(1, 2, 3, 4, 5, 6)},
            {new ArrayList<>(), Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6)},
            {Arrays.asList(1, 3, 5), Arrays.asList(1, 2, 4, 6), Arrays.asList(1, 1, 2, 3, 4, 5, 6)},
            {Arrays.asList(1, 2, 4, 6), Arrays.asList(1, 3, 5), Arrays.asList(1, 1, 2, 3, 4, 5, 6)}
        });
    }
    
    private static List<Integer> streamIntoList(Iterator<Integer> m) {
        List<Integer> merged = new ArrayList<>();
        while (m.hasNext()) {
            merged.add(m.next());
        }
        return merged;
    }
}
