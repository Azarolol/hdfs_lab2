package hdfs.lab2.azarolol;

import org.apache.hadoop.io.WritableComparable;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    private final int ID;
    private final boolean indicator;

    public AirportWritableComparable(int ID, boolean indicator) {
        this.ID = ID;
        this.indicator = indicator;
    }
}