package Streams.ObjStreams;



/*
    This class exists to have usable Objects to test and demonstrate
    Object Streams and the usage of their methods.
 */
public class TestObject {
    private int x1;
    private long x2;
    private double y1;

    public TestObject(int x1, long x2, double y1){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
    }
    @Override
    public String toString(){
        return "This is a TestObject with the values: int: " + x1 + ", long: " + x2 + ", double: " + y1;
    }

    public int getX1() {
        return x1;
    }

    public long getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }
}
