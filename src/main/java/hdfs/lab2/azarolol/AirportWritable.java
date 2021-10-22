package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.Objects;

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
        String airportID = fields[0];
        if (Objects.equals(airportID, "\"Code\"")) {
            return new AirportWritable("", new IntWritable(0));
        }
        IntWritable ID = new IntWritable(Integer.parseInt(fields[0]));
        String name = fields[1];
        return new AirportWritable(name, ID);
    }
}