package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;

public class FlightWritable {
    private final IntWritable destinationAirportID;
    private final IntWritable delayTime;

    public FlightWritable(IntWritable destinationAirportID, IntWritable delayTime) {
        this.destinationAirportID = destinationAirportID;
        this.delayTime = delayTime;
    }

    public IntWritable getDelayTime() {
        return delayTime;
    }

    public IntWritable getDestinationAirportID() {
        return destinationAirportID;
    }

    public static FlightWritable read(String input) {
        String[] fields = input.split(",");
        int destinationAirportID = Integer.parseInt(fields[14]);
        int delayTime = Integer.parseInt(fields[18]);
        return new FlightWritable(destinationAirportID, delayTime);
    }
}