package org.thinkbigthings.katas.trees;

import static java.util.Spliterator.DISTINCT;
import static java.util.Spliterator.IMMUTABLE;
import static java.util.Spliterator.NONNULL;
import static java.util.Spliterator.ORDERED;

import com.google.common.collect.Range;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Spliterators.AbstractSpliterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PointNode {

    private static final BigDecimal TWO = new BigDecimal(2);
    public  static final PointNode  UNIT_INSTANCE = new PointNode(Range.closed(BigDecimal.ZERO, BigDecimal.ONE));

    private final Range<BigDecimal> range;
    private final BigDecimal value;

    public PointNode(Range<BigDecimal> _range) {
        range = _range;
        value = range.lowerEndpoint().add((range.upperEndpoint().subtract(range.lowerEndpoint())).divide(TWO));
    }

    public PointNode getLeftChild() {
        return new PointNode(Range.closed(range.lowerEndpoint(), value));
    }

    public PointNode getRightChild() {
        return new PointNode(Range.closed(value, range.upperEndpoint()));
    }
    
    
    public BigDecimal getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof PointNode)) {
            return false;
        }
        return value.equals(((PointNode)other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    //////////////////////////////////////////////////

    public void breadthFirstSimple(Consumer<PointNode> visitor, int depth) {
        breadthFirstSimple(visitor, Arrays.asList(this), depth);
    }
    
    protected void breadthFirstSimple(Consumer<PointNode> visitor, List<PointNode> supplier, int depth) {
        
        if(depth <= 0) {
            return;
        }
        
        for(PointNode node : supplier) {
            visitor.accept(node);
        }
        
        List<PointNode> subTrees = new ArrayList<>();
        for(PointNode node : supplier) {
            subTrees.addAll(Arrays.asList(node.getLeftChild(), node.getRightChild()));
        }
        
        breadthFirstSimple(visitor, subTrees, depth - 1);
        
    }
    
    ///////////////////////////////////////
    
    public void breadthFirst(Consumer<PointNode> visitor, int depth) {
        breadthFirst(visitor, Stream.<PointNode>builder().add(this).build(), depth);
    }
    
    protected void breadthFirst(Consumer<PointNode> visitor, Stream<PointNode> supplier, int depth) {
        
        if(depth == 0) {
            return;
        }
        
        // want to accumulate child nodes into a stream
        Stream<PointNode> childStream = supplier.peek(visitor)
                                                .map((node) -> node.streamChildren())
                                                .reduce(Stream.empty(), Stream::concat);
        
        breadthFirst(visitor, childStream, depth - 1);

        
    }
    
    protected Stream<PointNode> streamChildren() {
        return Stream.<PointNode>builder().add(this.getLeftChild()).add(this.getRightChild()).build().sequential();
    }
    
    ///////////////////////////////////////
    
    public Stream<PointNode> stream() {
        return StreamSupport.stream(new BreadthFirstSpliterator(this), false);
    }
    
    protected static class BreadthFirstSpliterator extends AbstractSpliterator<PointNode> {
        
        private final Queue<PointNode> nodes = new LinkedBlockingQueue<>();
        
        public BreadthFirstSpliterator(PointNode root) {
            super(Long.MAX_VALUE, ORDERED | DISTINCT | NONNULL | IMMUTABLE);
            nodes.add(root);
        }

        @Override
        public boolean tryAdvance(Consumer<? super PointNode> action) {
            PointNode current = nodes.remove();
            action.accept(current);
            nodes.addAll(Arrays.asList(current.getLeftChild(), current.getRightChild()));
            return true;
        }
    }
    
}
