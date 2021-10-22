package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    private final IntWritable ID;
    private final IntWritable indicator;

    public IntWritable getID() {
        return ID;
    }

    public IntWritable getIndicator() {
        return indicator;
    }

    public AirportWritableComparable() {
        this.ID = new IntWritable(0);
        this.indicator = new IntWritable(0);
    }

    public AirportWritableComparable(IntWritable ID, IntWritable indicator) {
        this.ID = ID;
        this.indicator = indicator;
    }

    @Override
    public int compareTo(AirportWritableComparable o) {
        int result = this.ID.compareTo(o.getID());
        if (result == 0) {
            return this.indicator.compareTo(o.getIndicator());
        }
        return result;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        ID.write(dataOutput);
        indicator.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        ID.readFields(dataInput);
        indicator.readFields(dataInput);
    }
}