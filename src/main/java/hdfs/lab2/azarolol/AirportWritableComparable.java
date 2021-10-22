package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    private final IntWritable ID;
    private final boolean indicator;

    public IntWritable getID() {
        return ID;
    }

    public boolean getIndicator() {
        return indicator;
    }

    public AirportWritableComparable(IntWritable ID, boolean indicator) {
        this.ID = ID;
        this.indicator = indicator;
    }

    @Override
    public int compareTo(AirportWritableComparable o) {
        return this.ID.compareTo(o.getID());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}