package NumStreams;

import ObjStreams.TestObject;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {
    /**
     * not too much to know and learn about IntStreams.
     * But they can be very useful! IntStream(range) creates a new IntStream in the given range (Start inclusive, end exclusive)
     * should be self-explanatory :^)
     */
    public IntStream intStreamFromRange(int start, int end){
        return IntStream.range(start, end);
    }

    public IntStream intStreamFromValues(int ... values){
        return IntStream.of(values);
    }

    public int sum(IntStream stream){
        return stream.sum();
    }
    public double average(IntStream stream){
        return stream.average().orElse(0);
    }

    public Stream<TestObject> mapToObj(IntStream stream){
        return stream.mapToObj(i -> new TestObject(i, i, i/2.5));
    }


}
