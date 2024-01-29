package Streams.ObjStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.*;

public class Standards {
    /**
     * the empty Stream:
     */
    public Stream<TestObject> empty(){
        return Stream.empty();
    }


    /**
     Important: map()
     Usage: map(Function mapper)

     **/
    public void mapToString(Stream<TestObject> stream){
        stream.map(TestObject::toString).forEach(System.out::println);
    }

    /**
        map from an Object Stream to an IntStream containing Integers:
        mapToInt(Function mapper)
     **/
    public IntStream mapToInt(Stream<TestObject> stream){
        return stream.mapToInt(TestObject::getX1);
    }
    /**
     map from (Object) Stream to a LongStream containing Integers:
     mapToInt(Function mapper)
     **/
    public LongStream mapToLong(Stream<TestObject> stream){
        return stream.mapToLong(TestObject::getX2);
    }
    /**
     map from (Object) Stream to a DoubleStream containing Integers:
     mapToInt(Function mapper)
     **/
    public DoubleStream mapToDouble(Stream<TestObject> stream){
        return stream.mapToDouble(TestObject::getY1);
    }

    /**
     * "just look into Stream" (needs Consumer)
     */
    public Stream<TestObject> peek(Stream<TestObject> stream){
        return stream.peek(TestObject::toString);
    }


    /**
     How to initialize Streams from Arrays and Lists and how to collect them again:
    **/

    public Stream<TestObject> arrayToStream(TestObject[] objects){
        return Arrays.stream(objects);
    }

    public Stream<TestObject> ListToStream(List<TestObject> objects){
        return objects.stream();
    }
    public List<TestObject> collectToList(Stream<TestObject> stream){
        return stream.collect(Collectors.toList());
    }

    public TestObject[] collectToArray(Stream<TestObject> stream){
        return stream.toArray(TestObject[]::new);
        // or: return stream.collect(Collectors.toList()).toArray;
    }

    public String collectToString(Stream<TestObject> stream, String delimeter) {
        return stream.map(TestObject::toString).collect(Collectors.joining(delimeter));
    }

    /**
     *Returns a map mapping the y member of the objects to the number of objects with this y value in the stream.
     * Collectors.groupingBy(Function, collector)
     */
    public Map<Double, Long> collectToMap(Stream<TestObject> stream){
        return stream.collect(Collectors.groupingBy(TestObject::getY1, Collectors.counting()));
    }

    /**
     * returning booleans from streams with anyMatch(Predicate) or noneMatch()
     * testObject -> testObject.getX1() == 1 is only an example of what a Predicate can look like.
     */
    public boolean doesOneMatch(Stream<TestObject> stream){
        return stream.anyMatch(testObject -> testObject.getX1() == 1);
    }
    public boolean doesNoneMatch(Stream<TestObject> stream){
        return stream.noneMatch(testObject -> testObject.getX1() == 1);
    }
    /**
     * also using Predicates:
     * takeWhile(Predicate) takes Elements from the stream until one that does match
     * the Predicate comes up or the Stream has no more elements.
     *
     * filter(Predicate) returns a stream consisting of the elements matching the predicate
     */

    public Stream<TestObject> takeWhile(Stream<TestObject> stream, Predicate<TestObject> predicate){
        return stream.takeWhile(predicate);
    }
    public Stream<TestObject> filter(Stream<TestObject> stream, Predicate<TestObject> predicate){
        return stream.filter(predicate);
    }


    /**
     * Comparators play a big role when searching for biggest / smallest value or sorting.
     * Examples with min(Comparator), max(Comparator), sorted(Comparator)
     *
     * Additional information for using Doubles:
     * Doubles can contain values (or contain null) so we have to return a value if we cant find a fitting solution
     * Here I used null, which does not make much sense. If you want to use Optionals properly, find a default value!
     */

    public TestObject maxValue(Stream<TestObject> stream){
        return stream.max(Comparator.comparingDouble(TestObject::getY1)).orElse(null);
    }
    public TestObject minValue(Stream<TestObject> stream){
        return stream.min(Comparator.comparingLong(TestObject::getX2)).orElse(null);
    }
    public Stream<TestObject> sort(Stream<TestObject> stream){
        return stream.sorted(Comparator.comparingInt(TestObject::getX1));
    }

    /**
     * a little bit more complicated:
     * flatMap(Function) makes it possible to have one Stream from a Stream<Stream<Object>>
     * be careful, this implementation might not work!
     */

    public Stream<TestObject> flatMap(Stream<TestObject> stream1, Stream<TestObject> stream2){
        return stream1.flatMap(s -> stream2);
    }

    /**
     * Stream.concat concatenates two streams.
     */
    public Stream<TestObject> concat(Stream<TestObject> stream1, Stream<TestObject> stream2){
        return Stream.concat(stream1, stream2);
    }








}
