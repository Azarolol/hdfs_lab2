package hdfs.lab2.azarolol;

public class AirportWritable {
    private final String name;
    private final int ID;

    public AirportWritable(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public static AirportWritable read(String input) {
        String[] fields = input.split(",");
        int ID = Integer.parseInt(fields[0]);
        String name = fields[1];
        return new AirportWritable(name, ID);
    }
}