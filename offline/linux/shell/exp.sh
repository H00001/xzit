#!/bin/bash
a=1
b=2
c="$[a+b]"
d="$(expr $a + $b)"
echo $c
echo $d
