#!/bin/bash

killall -9 java 2>/dev/null
/usr/bin/screen -d -m java -jar jvzlogger.jar main.Main
