#!/bin/bash

#Run the mapper and reducer (an issue need to be fixed)
hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar -input /data/training/shakespeare/comedies -output output_wc_unix -mapper /bin/cat -reducer /usr/bin/wc
