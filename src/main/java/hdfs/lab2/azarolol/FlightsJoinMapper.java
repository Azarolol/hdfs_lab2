package hdfs.lab2.azarolol;

import org.apache.mapreduce.Mapper;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) {
        Flight mappingFlight = 
    }
}