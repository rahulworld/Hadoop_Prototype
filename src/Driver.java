

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.javax.xml.soap.Text
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

public class Driver 
{
      public static void main(String[] args) throws Exception 
      {
    	  if(args.length!=2)
    	  {
    		  System.err.print("Please provide input and output paths");
    		  System.exit(-1);
    	  }
    	  
    	  Job job = new Job();
    	  job.setJarByClass(Driver.class);
    	  job.setJobName("SachinerScore");
    	  FileInputFormat.addInputPath( job, new Path( args[0] ) );
		  FileOutputFormat.setOutputPath( job, new Path( args[1] ) );
		  
		  
		  job.setMapperClass(MyMapper.class);
		  job.setReducerClass(MyReducer.class);
		  
		  job.setOutputKeyClass(Text.class);
		  job.setOutputValueClass(IntWritable.class);
    
		  
		  System.exit(job.waitForCompletion(true)?0:1);
	  }
}
