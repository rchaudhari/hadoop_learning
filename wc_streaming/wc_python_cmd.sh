#!/bin/bash

#Test the mapper function out of hadoop first
echo "fox cat dog fox dog ant rabbit crow cow cow" | ./mapper.py

#Test the reducer functions out of hadoop first
echo "fox cat dog fox dog ant rabbit crow cow cow" | ./mapper.py | sort -k1,1 | ./reducer.py

#If you see sucess above, then run it on hadoop cluster/sandbox
hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar -input /data/training/shakespeare/comedies -output output_wc_python -file ./mapper.py -mapper ./mapper.py -file ./reducer.py -reducer ./reducer.py
