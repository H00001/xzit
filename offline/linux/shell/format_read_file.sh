#!/bin/bash
IFS=:
cat format_file | while read ip user pass
do    
	echo "$ip--$user--$pass"
done
