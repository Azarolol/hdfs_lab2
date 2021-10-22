package hdfs.lab2.azarolol;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        AirportWritable mappingAirport = AirportWritable.read(value.toString().replaceAll("\"", ""));
        context.write(new AirportWritableComparable(mappingAirport.getID(), new IntWritable(0)), new Text(String.valueOf(mappingFlight.getDelayTime())));
    }
}
