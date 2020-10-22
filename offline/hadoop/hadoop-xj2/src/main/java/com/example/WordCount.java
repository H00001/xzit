package com.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Iterator;


public class WordCount {
    public static class WordPart extends Partitioner<Text,LongWritable>{

        @Override
        public int getPartition(Text text, LongWritable longWritable, int i) {
            return 0;
        }
    }

    public static class Comp extends Text.Comparator{
        
    }

    public static class MyGroup implements RawComparator<Text> {

        @Override
        public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
            return 0;
        }

        @Override
        public int compare(Text o1, Text o2) {
            LineRecordReader
            return 0;
        }
    }
    public static class WordMap extends Mapper<LongWritable, Text,Text,LongWritable>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            // value:"math math english"
            String[] s = value.toString().split(" ");
            // s :math,math,english
            for (String v : s){
                context.write(new Text(v),new LongWritable(1));
                // math:1,math:1,english:1
                // combiner :math:1+1->2
                // text本质还是string v longwriteable本质还是 数字1
            }
        }
    }
    public static class WordReduce extends Reducer<Text,LongWritable,Text,LongWritable>{
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            // math->[1,1,1,1] english->1
            // combiner -> [2,1,1]
            // key:math value:[1,1] value[1]
            int v = 0;
           Iterator<LongWritable> ll = values.iterator();
           for (;ll.hasNext();){
               v += ll.next().get();
           }
           context.write(key,new LongWritable(v));
        }
    }

    public class CountParn extends Partitioner<Text,LongWritable>{

        @Override
        public int getPartition(Text text, LongWritable longWritable, int i) {
            return text.hashCode()&i;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration c = new Configuration();
        Job j = Job.getInstance(c);
        j.setJarByClass(WordCount.class);
        j.setMapperClass(WordMap.class);
        j.setReducerClass(WordReduce.class);
        j.setMapOutputKeyClass(Text.class);
        j.setMapOutputValueClass(LongWritable.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(LongWritable.class);
        j.setPartitionerClass(CountParn.class);
        FileInputFormat.setInputPaths(j,new Path(args[0]));
        FileOutputFormat.setOutputPath(j,new Path(args[1]));
        j.waitForCompletion(true);
    }
}
