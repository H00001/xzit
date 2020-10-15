## How to config a cluster of hadoop

**configure file**

> Hadoop-env.sh

core-site.xml
```xml
<configuration>  
	<property>							
		<name>fs.defaultFS</name> 	
  	<value>hdfs://xx:9000</value>  
	</property>
	<property>
    <name>hadoop.tmp.dir</name>
    <value>/home/hadoop/tmp</value>
	</property>
</configuration>
```
master is a master node

hdfs-site.xml

```xml
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>3</value>
    </property>
    <property>
        <name>dfs.namenode.secondary.http-address</name>
        <value>xx:50090</value>
    </property>
</configuration>
```

Yarn-site.xml

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

mapred-site.xml

```xml
<configuration>
      <property>
          <name>mapred.job.tracker</name>
           <value>master:9001</value>
       </property>
<property> <name>mapreduce.framework.name</name> <value>yarn</value>
          </property>
</configuration>
```

slaves

xxx