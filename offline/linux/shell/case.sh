#!/bin/bash
a=$1
if [[ -z $a ]]
then
	read -p "please input a:" a 
fi
case $a in 
1)
	echo "value a is 1"
	;;
2)
	echo "this is a firut"
	;;
*)
	echo "error"
esac
