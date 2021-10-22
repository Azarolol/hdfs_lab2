package hdfs.lab2.azarolol;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;

public class FlightWritable {
    private final IntWritable destinationAirportID;
    private final FloatWritable delayTime;

    public FlightWritable(IntWritable destinationAirportID, FloatWritable delayTime) {
        this.destinationAirportID = destinationAirportID;
        this.delayTime = delayTime;
    }

    public FloatWritable getDelayTime() {
        return delayTime;
    }

    public IntWritable getDestinationAirportID() {
        return destinationAirportID;
    }

    public static FlightWritable read(String input) {
        FloatWritable delayTime;
        String[] fields = input.split(",");
        try {
            delayTime = new FloatWritable(Float.parseFloat(fields[18]));
        } catch (NumberFormatException n) {
            delayTime = new FloatWritable(0);
        }
        IntWritable destinationAirportID = new IntWritable(Integer.parseInt(fields[14]));
        return new FlightWritable(destinationAirportID, delayTime);
    }
}