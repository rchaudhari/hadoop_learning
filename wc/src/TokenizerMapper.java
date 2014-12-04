/**
 *  Following sample is influenced by WordCount examples in
 *  Book: Hdoop Definative Guide 3rd Edition
 *  @Author: Rahul Chaudhari
 **/

package wc;

//Libraries - Required by the Mapper and Reducer
import java.util.StringTokenizer;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/**
 * The word count sample counts the number of word occurrences within a set of input documents
 * using MapReduce.
 */

/**
 * The mapper extends from the org.apache.hadoop.mapreduce.Mapper interface.
 * When Hadoop runs, it receives each new line in the input files as an input to
 * the mapper. The map function tokenize the line, and for each token (word)
 * emits (word,1) as the output.
 */
public class TokenizerMapper
    extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    public void map(Object key, Text value, Context context) throws
        IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken().trim().replaceAll("[^\\dA-Za-z ]", ""));
            context.write(word,one);
        }
    }
}
