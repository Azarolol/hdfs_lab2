package hdfs.lab2.azarolol;

public class AirportWritable {
    private final String name;
    private final int ID;

    public Airport(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public read(String input) {
        String[] fields = input.split(",");
        int ID = Integer.parseInt(fields[])
    }
}