package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Objects;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueTrimmed = value.toString().replaceAll("\"", "");
        if (!(valueTrimmed.split(",")[18].equals(""))) {
            FlightWritable mappingFlight = FlightWritable.read(valueTrimmed);
            IntWritable ID = mappingFlight.getDestinationAirportID();
            if (ID.hashCode() != 0) {
                context.write(new AirportWritableComparable(ID, new IntWritable(1)), new Text(String.valueOf(mappingFlight.getDelayTime())));
            }
        }
    }
}