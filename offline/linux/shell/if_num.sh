#!/bin/bash
if (( $1 == $2 ));then
	echo "$1 == $2"
else
	if (( $1 > $2 ));then
		echo "$1 > $2"
	else
		echo "$1 < $2"
	fi
fi
