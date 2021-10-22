package hdfs.lab2.azarolol;

public class FlightWritable {
    private final int destinationAirportID;

    public FlightWritable(int destinationAirportID) {
        this.destinationAirportID = destinationAirportID;
    }

    public static FlightWritable read(String input) {
        String[] fields = input.split(",");
        int destinationAirportID = Integer.parseInt(fields[14]);
        return new FlightWritable(destinationAirportID);
    }
}