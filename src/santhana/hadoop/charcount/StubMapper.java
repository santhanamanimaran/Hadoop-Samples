package santhana.hadoop.charcount;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<Object, Text, IntWritable, LongWritable> {

  @Override
  public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {

	  //Split the line into words with spaces or tabs as separators
	  /*String[] words = value.toString().split("[ \t]+");
	  for(String word:words)
	  {
		  //Remove all alpha numeric characters 
		  word = word.replaceAll("[^a-zA-Z0-9]", "");
		  
		  //convert the word to lower case
		  word = word.toLowerCase();
		  
		  context.write(new Text(word), new LongWritable(1));
	  }*/
	  String line = value.toString();
	  for (int i = 0; i < line.length(); i++) {
		  char c = line.charAt(i);
		  context.write(new IntWritable(c), new LongWritable(1));
	  }
  }
}
