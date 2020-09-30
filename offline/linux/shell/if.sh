#!/bin/bash
read a
read b
# -z STRING ] 如果STRING的长度为零则返回为真，即空是真
#[ -n STRING ] 如果STRING的长度非零则返回为真，即非空是真
#[ STRING1 ]　 如果字符串不为空则返回为真,与-n类似
#[ STRING1 == STRING2 ] 如果两个字符串相同则返回为真
#[ STRING1 != STRING2 ] 如果字符串不相同则返回为真
#[ STRING1 < STRING2 ] 如果 “STRING1”字典排序在“STRING2”前面则返回为真
#[ STRING1 > STRING2 ] 如果 “STRING1”字典排序在“STRING2”后面则返回为真
if [[ $b > $a ]]
then
	echo "b > a"
else
	echo "b < a"
fi
