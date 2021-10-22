package hdfs.lab2.azarolol;

public class FlightWritable {
    private final int destinationAirportID;
    private final int delayTime;

    public FlightWritable(int destinationAirportID, int delayTime) {
        this.destinationAirportID = destinationAirportID;
        this.delayTime = delayTime;
    }

    public int getDestinationAirportID() {
        return destinationAirportID;
    }

    public static FlightWritable read(String input) {
        String[] fields = input.split(",");
        int destinationAirportID = Integer.parseInt(fields[14]);
        return new FlightWritable(destinationAirportID);
    }
}