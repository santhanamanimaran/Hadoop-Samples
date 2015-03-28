package santhana.hadoop.charcount;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<IntWritable, LongWritable, Text, LongWritable> {

  @Override
  public void reduce(IntWritable key, Iterable<LongWritable> values, Context context)
      throws IOException, InterruptedException {
	  
	  long sum = 0;
	  for(LongWritable iw:values)
	  {
		  sum += iw.get();
	  }
	  context.write(new Text(key.toString()), new LongWritable(sum));
  }
}
