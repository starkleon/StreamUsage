package NumStreams;

import ObjStreams.TestObject;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DoubleStreams {
    public DoubleStream doubleStreamFromValues(double ... values){
        return DoubleStream.of(values);
    }

    public double sum(DoubleStream stream){
        return stream.sum();
    }
    public double average(DoubleStream stream){
        return stream.average().orElse(0);
    }

    public Stream<TestObject> mapToObj(DoubleStream stream){
        return stream.mapToObj(i -> new TestObject(Math.getExponent(i), Math.round(i), i/2.5));
    }
}
