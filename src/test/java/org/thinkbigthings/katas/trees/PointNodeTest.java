package org.thinkbigthings.katas.trees;

import static org.junit.Assert.*;

import com.google.common.collect.Range;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class PointNodeTest {

    private final List<BigDecimal> breadthFirst = Arrays.asList(new BigDecimal(0.5), 
                                                                 new BigDecimal(0.25), 
                                                                 new BigDecimal(0.75),
                                                                 new BigDecimal(0.125),
                                                                 new BigDecimal(0.375),
                                                                 new BigDecimal(0.625),
                                                                 new BigDecimal(0.875));

    
    @Test
    public void testTraversal() throws Exception {

        PointNode root = new PointNode(Range.closed(BigDecimal.ZERO, BigDecimal.TEN));
        
        assertEquals(new BigDecimal(5), root.getValue());
        assertEquals(new BigDecimal(2.5), root.getLeftChild().getValue());
        assertEquals(new BigDecimal(7.5), root.getRightChild().getValue());
        assertEquals(new BigDecimal(1.25), root.getLeftChild().getLeftChild().getValue());
    }
    
    @Test
    public void breadthFirstSimple() throws Exception {
        
        List<BigDecimal> traversal = new ArrayList<>();
        PointNode.UNIT_INSTANCE.breadthFirstSimple((n)-> traversal.add(n.getValue()), 3);
        
        assertEquals(breadthFirst, traversal);
    }
    
    @Test
    public void breadthFirst() throws Exception {
        
        List<BigDecimal> traversal = new ArrayList<>();
        PointNode.UNIT_INSTANCE.breadthFirst((n)-> traversal.add(n.getValue()), 3);
        
        assertEquals(breadthFirst, traversal);    
    }
    
    @Test
    public void stream() throws Exception {
        
        List<BigDecimal> traversal = PointNode.UNIT_INSTANCE
                .stream()
                .map(n -> n.getValue())
                .limit(breadthFirst.size())
                .collect(Collectors.toList());
        
        assertEquals(breadthFirst, traversal);
    }

}
