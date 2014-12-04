/**
 * Following sample is influenced by WordCount examples in
 * Book: Hdoop Definative Guide 3rd Edition
 * @Author: Rahul Chaudhari
 */

package wc;

//Libraries - Required by the Mapper and Reducer
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/**
 * The word count sample counts the number of word occurrences within a set of input documents
 * using MapReduce.
 */

/**
 * Reduce function receives all the values that has the same key as the input, and it output the key
 * and the number of occurrences of the key as the output.
 */
public class IntSumReducer
    extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws
        IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        result.set(sum);
        context.write(key, result);
    }
}
