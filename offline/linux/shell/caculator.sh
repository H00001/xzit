#!/bin/bash
read -p "please input first orerator number:" a
read -p "please input orerator command:" o
read -p "please input scend orerator number:" b
if [[ $o == "+" ]];then
	c="$[a+b]"
elif [[ $o == "-" ]];then
	c="$((a-b))"
elif [[ $o == "*" ]];then
	c=$(expr $a * $b)
elif [[ $o == "/" ]];then
	c=$[a/b]
else
     	c="operator is invidia $o"
fi
echo $c

