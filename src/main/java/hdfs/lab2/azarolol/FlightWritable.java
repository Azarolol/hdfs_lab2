package hdfs.lab2.azarolol;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;

public class FlightWritable {
    private static final String DELIMITER = ",";
    private static final int DELAY_TIME_INDEX = 18;
    private static final int DESTINATION_AIRPORT_ID_INDEX = 14;

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
        IntWritable destinationAirportID;
        String[] fields = input.split(DELIMITER);
        try {
            delayTime = new FloatWritable(Float.parseFloat(fields[DELAY_TIME_INDEX]));
            destinationAirportID = new IntWritable(Integer.parseInt(fields[DESTINATION_AIRPORT_ID_INDEX]));
        } catch (NumberFormatException n) {
            return new FlightWritable(new IntWritable(0), new FloatWritable(0));
        }
        return new FlightWritable(destinationAirportID, delayTime);
    }
}