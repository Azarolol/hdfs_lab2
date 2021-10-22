package hdfs.lab2.azarolol;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) {
        FlightWritable mappingFlight = FlightWritable.read(value.toString().replaceAll("\"", ""));
        context.write(new AirportWritableComparable(mappingFlight.getDestinationAirportID(), 0), new Text(mappingFlight.getDelayTime()));
    }
}