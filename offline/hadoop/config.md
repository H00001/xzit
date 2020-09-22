# How to config a cluster of hadoop

## configure file

core-site.xml

> master is a master node

```xml
 <configuration>
   <property>
     <name>fs.defaultFS</name>
     <value>hdfs://master:9000</value>
   </property>
 </configuration>
```

hdfs-site.xml

```xml
  <configuration>
    <property>
      <name>dfs.replication</name>
      <value>3</value>
    </property>
  </configuration>
```

mapred-site.xml

```xml
<configuration>
　　　　　　<property>
　　　　　　　　<name>mapred.job.tracker</name>
　　　　　　　　<value>master:9001</value>
　　　　　　</property>
          <property>
                <name>mapreduce.framework.name</name>
                <value>yarn</value>
          </property>
</configuration>
```

yarn-size.xml
```xml
<configuration>
        <property>
                <name>yarn.resourcemanager.hostname</name>
                <value>master</value>
        </property>
        <property>
                <name>yarn.nodemanager.aux-services</name>
                <value>mapreduce_shuffle</value>
        </property>
        <property>
                <name>yarn.log-aggregation-enable</name>
                <value>true</value>
        </property>
        <property>
                <name>yarn.log-aggregation.retain-seconds</name>
                <value>604800</value>
        </property>
</configuration>
```

the end.
