#!/bin/bash
# 检查文件是否存在
if [[ -f $1 ]]; then
	# 检查文件是否可读
	if [[ -r $1 ]]; then
		echo "the file can be read"
	fi
	# 检查文件是否可写
	if [[ -w $1 ]]; then
		echo "the file can be writted"
	fi
# 检查是不是目录
elif [[ -d $1 ]];then
	echo "path is a directory"
else
	echo "path is not exist"
fi
