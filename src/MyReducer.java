
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>
{
    @Override
    public void reduce(Text key1, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
    {
    	int sum = 0;
    	
for(IntWritable value : values) {
    		sum = sum + value.get();
    	}
    	context.write(key1,new IntWritable(sum));
    }
}