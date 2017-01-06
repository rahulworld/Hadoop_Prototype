

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable> 
{
     @Override
     public void map(LongWritable key1, Text value1,Context context) throws IOException,InterruptedException
     {
    	 String line = value1.toString();
    	 
    	 StringTokenizer st = new StringTokenizer(line," ");
    	 
    	 String BatsmanName = st.nextToken();
      
         for(int i=1;i<3;i++)
             st.nextToken();

    	 String Runs = st.nextToken();
    	 
    	 int x = Integer.parseInt(Runs);
    	 
    	 if(BatsmanName.equals("sachin"))
    	 {
    	     context.write(new Text(BatsmanName),new IntWritable(x));
    	 }
     }
}