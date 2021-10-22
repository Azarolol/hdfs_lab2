package hdfs.lab2.azarolol;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text name = new Text(iter.next().toString());
        if (!iter.hasNext()) {
            return;
        }
        float delay = Float.parseFloat(iter.next().toString());
        float maxDelay = delay;
        float minDelay = delay;
        float totalDelay = delay;
        int delayNumber = 1;
        while (iter.hasNext()) {
            String next = iter.next().toString();
            if (next.matches("^\\d+\\.\\d+$")) {
                delay = Float.parseFloat(iter.next().toString());
                maxDelay = Math.max(maxDelay, delay);
                minDelay = Math.min(minDelay, delay);
                totalDelay += delay;
                delayNumber++;
            }
        }
        float averageDelay = totalDelay / delayNumber;
        context.write(name, new Text(String.format("Minimal delay = %f, Average delay = %f, Maximal delay = %f", minDelay, averageDelay, maxDelay)));
    }
}
