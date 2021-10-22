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
        IntWritable destinationAirportID = new IntWritable(Integer.parseInt(fields[14]));
        try {
            IntWritable delayTime = new IntWritable(Integer.parseInt(fields[18]));
        } catch ()

        return new FlightWritable(destinationAirportID, delayTime);
    }
}