package hdfs.lab2.azarolol;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMPTY_STRING = "";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueTrimmed = value.toString().replaceAll(DOUBLE_QUOTES, EMPTY_STRING);
        FlightWritable mappingFlight = FlightWritable.read(valueTrimmed);
        IntWritable ID = mappingFlight.getDestinationAirportID();
        FloatWritable delay = mappingFlight.getDelayTime();
        if (ID.hashCode() != 0 && delay.hashCode() > 0) {
            context.write(new AirportWritableComparable(ID, new IntWritable(1)), new Text(String.valueOf(delay)));
        }
    }
}