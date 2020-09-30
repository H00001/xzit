#!/bin/bash
a="hello"
b="zzz"
if [[ $a == "hello" ]]; then
	echo "a is hello"
fi
if [[ $a == $b ]]; then
	echo "a equal with b"
elif [[ $a > $b ]]; then
	echo "a > b"
else
	echo "a < b"
fi
if [[ -n $1 ]]; then
	echo "$1 is not empty"
elif [[ -z $1 ]]; then
	echo "$1 is empty"
fi
