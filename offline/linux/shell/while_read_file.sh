#!/bin/bash
# line是读取的每一行的变量
while read line
do
	echo "$line"
done < for
# for 是文件名
