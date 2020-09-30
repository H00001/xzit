#!/bin/bash
#`java` int i = 1
i=1
#`java` while(i<=5)
while(( $i<=5 ))
do
    echo $i
#`java` i++
    let "i++"
done
