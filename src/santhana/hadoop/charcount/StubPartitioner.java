package santhana.hadoop.charcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class StubPartitioner extends Partitioner<Text, LongWritable>
{
	
	@Override
	public int getPartition(Text key, LongWritable arg1, int arg2) {
		
		String keyS = key.toString();
		if((keyS.length() > 0) && (keyS.charAt(0) < 'k'))
		 {
			 return 0;
		 }
		 return 1;
	}

}
