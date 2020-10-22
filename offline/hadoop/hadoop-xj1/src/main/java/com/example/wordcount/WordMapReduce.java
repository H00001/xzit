package com.example.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class WordMapReduce {
    // Mapper中的四个泛型，分别是key in，value in
    // keyin该节点获得的字符串对应于问文本内容的偏移字节
    // keyvalue 是一行的字符串
    // keyout和valueout分别是对应的字符串和出现的次数
    public static class WordMap extends
            Mapper<Object, Text,Text, LongWritable>{
        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            // key : 0
            // value: math math english
            String[] l = value.toString().split(" ");
            // math,math,english
            for (String v : l){
                // math 1
                context.write(new Text(v),new LongWritable(1));
            }
            // math:1,math:1,english:1
        }
    }
    public static class WordReduce extends Reducer<Text, LongWritable,Text,LongWritable>{
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            // math:[1,1],english：[1]
            int v = 0;
            Iterator<LongWritable> ll = values.iterator();
            for(;ll.hasNext();){
                 v += ll.next().get();
            }
            // math:2,english:1
            context.write(key,new LongWritable(v));
        }
    }
}

