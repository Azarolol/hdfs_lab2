package hdfs.lab2.azarolol;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportGroupingComparator extends WritableComparator {
    public AirportGroupingComparator() {
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        AirportWritableComparable airportWritableComparable1 = (AirportWritableComparable) a;
        AirportWritableComparable airportWritableComparable2 = (AirportWritableComparable) b;
        return airportWritableComparable1.getID().compareTo(airportWritableComparable2.getID());
    }
}
