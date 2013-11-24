package org.thinkbigthings.katas.streams;

import org.thinkbigthings.katas.streams.StreamMerger;
import static junit.framework.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StreamMergerTest {

    private final List<Integer> expectedMerge;
    private final StreamMerger<Integer> streamMerger = new StreamMerger<>();
    private final Stream<Integer> mergedStream;

    public StreamMergerTest(List<Integer> list1, List<Integer> list2, List<Integer> expected) {
        expectedMerge = expected;
        mergedStream = streamMerger.merge(list1.stream(), list2.stream());
    }

    @Test
    public void testStream() throws Exception {
        List<Integer> merged = mergedStream.collect(Collectors.<Integer>toList());
        assertEquals(expectedMerge, merged);
    }
    
    @Parameters
    public static List<Object[]> data() {
        return MergedIteratorTest.data();
    }

}
