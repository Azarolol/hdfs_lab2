package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;

public class AirportWritable {
    private final String name;
    private final IntWritable ID;

    public AirportWritable(String name, IntWritable ID) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IntWritable getID() {
        return ID;
    }

    public static AirportWritable read(String input) {
        String[] fields = input.split(",");
        IntWritable ID = new IntWritable(Integer.parseInt(fields[0]));
        String name = fields[1];
        return new AirportWritable(name, ID);
    }
}